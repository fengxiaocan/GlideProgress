package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;

import java.io.File;
import java.net.URL;

public class RequestManager2 extends RequestManager {
    public RequestManager2(
            @NonNull Glide glide,
            @NonNull Lifecycle lifecycle,
            @NonNull RequestManagerTreeNode treeNode,
            @NonNull Context context) {
        super(glide, lifecycle, treeNode, context);
    }

    public RequestManager2(
            Glide glide,
            Lifecycle lifecycle,
            RequestManagerTreeNode treeNode,
            RequestTracker requestTracker,
            ConnectivityMonitorFactory factory,
            Context context) {
        super(glide, lifecycle, treeNode, requestTracker, factory, context);
    }

    @NonNull
    @Override
    public RequestBuilder2<File> asFile() {
        return (RequestBuilder2<File>) super.asFile();
    }

    @NonNull
    @Override
    public RequestBuilder2<Bitmap> asBitmap() {
        return (RequestBuilder2<Bitmap>) super.asBitmap();
    }

    @NonNull
    @Override
    public RequestBuilder2<GifDrawable> asGif() {
        return (RequestBuilder2<GifDrawable>) super.asGif();
    }

    @NonNull
    @Override
    public RequestBuilder2<Drawable> asDrawable() {
        return (RequestBuilder2<Drawable>) super.asDrawable();
    }

    @NonNull
    @Override
    public <ResourceType> RequestBuilder2<ResourceType> as(@NonNull Class<ResourceType> resourceClass) {
        return new RequestBuilder2<>(glide, this, resourceClass, context);
    }

    @NonNull
    @Override
    public RequestBuilder2<Drawable> load(@Nullable String string) {
        return (RequestBuilder2<Drawable>) super.load(string);
    }

    @Override
    public RequestBuilder2<Drawable> load(@Nullable URL url) {
        return (RequestBuilder2<Drawable>) super.load(url);
    }

}
