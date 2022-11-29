package com.bumptech.glide;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerTreeNode;

import java.io.InputStream;

public class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule{
    public GeneratedAppGlideModuleImpl(Context context) {
    }

    @Nullable
    @Override
    RequestManagerRetriever.RequestManagerFactory getRequestManagerFactory() {
        return new RequestManagerRetriever.RequestManagerFactory() {
            @NonNull
            @Override
            public RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
                return new RequestManager2(glide, lifecycle, requestManagerTreeNode, context);
            }
        };
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader2.Factory());
    }
}
