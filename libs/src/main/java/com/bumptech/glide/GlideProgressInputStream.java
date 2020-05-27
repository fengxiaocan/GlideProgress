package com.bumptech.glide;

import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.load.model.GlideUrl;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GlideProgressInputStream extends FilterInputStream{
    private static final String TAG="ContentLengthStream";
    private static final int UNKNOWN=-1;
    private final GlideUrl glideUrl;
    private final long contentLength;
    private int readSoFar;

    @NonNull
    public static InputStream obtain(
            @NonNull InputStream other,@Nullable String contentLengthHeader,GlideUrl glideUrl)
    {
        return obtain(other,parseContentLength(contentLengthHeader),glideUrl);
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream other,long contentLength,GlideUrl glideUrl){
        return new GlideProgressInputStream(other,contentLength,glideUrl);
    }

    private static int parseContentLength(@Nullable String contentLengthHeader){
        int result=UNKNOWN;
        if(!TextUtils.isEmpty(contentLengthHeader)){
            try{
                result=Integer.parseInt(contentLengthHeader);
            } catch(NumberFormatException e){
                if(Log.isLoggable(TAG,Log.DEBUG)){
                    Log.d(TAG,"failed to parse content length header: "+contentLengthHeader,e);
                }
            }
        }
        return result;
    }

    private GlideProgressInputStream(@NonNull InputStream in,long contentLength,GlideUrl glideUrl){
        super(in);
        this.contentLength=contentLength;
        this.glideUrl=glideUrl;
    }

    @Override
    public synchronized int available() throws IOException{
        return (int)Math.max(contentLength-readSoFar,in.available());
    }

    @Override
    public synchronized int read() throws IOException{
        int value=super.read();
        checkReadSoFarOrThrow(value >= 0 ? 1 : -1);
        return value;
    }

    @Override
    public int read(byte[] buffer) throws IOException{
        return read(buffer,0 /*byteOffset*/,buffer.length /*byteCount*/);
    }

    @Override
    public synchronized int read(byte[] buffer,int byteOffset,int byteCount) throws IOException{
        return checkReadSoFarOrThrow(super.read(buffer,byteOffset,byteCount));
    }

    private int checkReadSoFarOrThrow(int read) throws IOException{
        if(read >= 0){
            readSoFar+=read;
            GlideProgressPack pack=GlidePack.getListener(glideUrl.toStringUrl());
            if(pack!=null){
                pack.onProgress(contentLength,readSoFar);
            }
        } else if(contentLength-readSoFar>0){
            throw new IOException(
                    "Failed to read all expected data"+", expected: "+contentLength+", but read: "+readSoFar);
        }else {
            GlideProgressPack pack=GlidePack.getListener(glideUrl.toStringUrl());
            if(pack!=null){
                pack.onProgress(1);
            }
        }
        return read;
    }
}

