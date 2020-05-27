package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

public class ImageTarget<Z> extends CustomViewTarget<ImageView,Z>{
    private Animatable animatable;
    private String model;

    public ImageTarget(@NonNull ImageView view,String model){
        super(view);
        this.model=model;
    }

    @Override
    protected void onResourceCleared(@Nullable Drawable placeholder){
        GlidePack.removeListener(model);
        if(animatable!=null){
            animatable.stop();
        }
        maybeUpdateAnimatable(null);
        view.setImageDrawable(placeholder);
    }

    @Override
    public void onLoadFailed(@Nullable Drawable errorDrawable){
        GlidePack.removeListener(model);
        if(animatable!=null){
            animatable.stop();
        }
        maybeUpdateAnimatable(null);
        view.setImageDrawable(errorDrawable);
    }

    @Override
    public void onResourceReady(
            @NonNull Z resource,@Nullable Transition<? super Z> transition)
    {
        GlidePack.removeListener(model);
        if(resource instanceof Drawable){
            view.setImageDrawable((Drawable)resource);
        } else if(resource instanceof Bitmap){
            view.setImageBitmap((Bitmap)resource);
        }
        maybeUpdateAnimatable(resource);
    }

    @Override
    protected void onResourceLoading(@Nullable Drawable placeholder){
        view.setImageDrawable(placeholder);
    }

    @Override
    public void onStart(){
        if(animatable!=null){
            animatable.start();
        }
    }

    @Override
    public void onStop(){
        if(animatable!=null){
            animatable.stop();
        }
    }

    @Override
    public void onDestroy(){
        GlidePack.removeListener(model);
        if(animatable!=null){
            animatable.stop();
        }
        maybeUpdateAnimatable(null);
    }

    private void maybeUpdateAnimatable(Object resource){
        if(resource instanceof Animatable){
            animatable=(Animatable)resource;
            animatable.start();
        } else{
            animatable=null;
        }
    }
}
