package com.bumptech.glide;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public final class GlidePack{
    private static final GlidePack sInstance=new GlidePack();

    private Map<String,GlideProgressPack> glide=new HashMap<>();

    static void addListener(String url,GlideProgressPack listener){
        if(url!=null){
            sInstance.glide.put(url,listener);
        }
    }

    static void removeListener(String tag){
        if(tag != null){
            sInstance.glide.remove(tag);
        }
    }

    static void clear(){
        sInstance.glide.clear();
    }

    static GlideProgressPack getListener(String tag){
        if(tag != null){
            return sInstance.glide.get(tag);
        }
        return null;
    }

    public static RequestManager2 with(Context context){
        return (RequestManager2)Glide.with(context);
    }
}
