package com.bumptech.glide;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

public class GlideTarget<Y extends Target<R>,R> implements Target<R>{
    private Y target;
    private String model;

    public GlideTarget(Y target,String model){
        this.target=target;
        this.model=model;
    }

    @Override
    public void onLoadStarted(@Nullable Drawable placeholder){
        target.onLoadStarted(placeholder);
    }

    @Override
    public void onLoadFailed(@Nullable Drawable errorDrawable){
        GlidePack.removeListener(model);
        target.onLoadFailed(errorDrawable);
    }

    @Override
    public void onResourceReady(
            @NonNull R resource,@Nullable Transition<? super R> transition)
    {
        GlidePack.removeListener(model);
        target.onResourceReady(resource,transition);
    }

    @Override
    public void onLoadCleared(@Nullable Drawable placeholder){
        GlidePack.removeListener(model);
        target.onLoadCleared(placeholder);
    }

    @Override
    public void getSize(@NonNull SizeReadyCallback cb){
        target.getSize(cb);
    }

    @Override
    public void removeCallback(@NonNull SizeReadyCallback cb){
        target.removeCallback(cb);
    }

    @Override
    public void setRequest(@Nullable Request request){
        target.setRequest(request);
    }

    @Nullable
    @Override
    public Request getRequest(){
        return target.getRequest();
    }

    @Override
    public void onStart(){
        target.onStart();
    }

    @Override
    public void onStop(){
        target.onStop();
    }

    @Override
    public void onDestroy(){
        GlidePack.removeListener(model);
        target.onDestroy();
    }
}
