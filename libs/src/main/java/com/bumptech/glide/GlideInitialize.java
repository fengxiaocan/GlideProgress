package com.bumptech.glide;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerTreeNode;

import java.io.InputStream;

public final class GlideInitialize{
    private static final GlideBuilder initialize(){
        GlideBuilder builder=new GlideBuilder();
        builder.setRequestManagerFactory(DEFAULT_FACTORY2);
        return builder;
    }

    public static final void initialize(Context context,GlideBuilder builder){
        initializeGlide(context,builder);
    }

    public static final void initialize(Context context){
        initialize(context,new GlideBuilder());
    }


    private static void initializeGlide(
            @NonNull Context context,@NonNull GlideBuilder builder)
    {
        Context applicationContext=context.getApplicationContext();
        builder.setRequestManagerFactory(DEFAULT_FACTORY2);
        Glide glide=builder.build(applicationContext);
        glide.getRegistry().replace(GlideUrl.class,InputStream.class,new HttpGlideUrlLoader2.Factory());
        applicationContext.registerComponentCallbacks(glide);
        Glide.init(glide);
    }


    public static final RequestManagerRetriever.RequestManagerFactory DEFAULT_FACTORY2=
            new RequestManagerRetriever.RequestManagerFactory(){
                @NonNull
                @Override
                public RequestManager2 build(
                        @NonNull Glide glide,
                        @NonNull Lifecycle lifecycle,
                        @NonNull RequestManagerTreeNode requestManagerTreeNode,
                        @NonNull Context context)
                {
                    return new RequestManager2(glide,lifecycle,requestManagerTreeNode,context);
                }
            };
}
