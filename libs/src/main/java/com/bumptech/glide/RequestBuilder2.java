package com.bumptech.glide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Executors;

import java.net.URL;

public class RequestBuilder2<TranscodeType> extends RequestBuilder<TranscodeType>{
    private GlideUrl glideUrl;
    private GlideProgressPack glideProgressPack;

    protected RequestBuilder2(
            @NonNull Glide glide,RequestManager requestManager,Class<TranscodeType> transcodeClass,Context context)
    {
        super(glide,requestManager,transcodeClass,context);
    }

    protected RequestBuilder2(Class<TranscodeType> transcodeClass,RequestBuilder other){
        super(transcodeClass,other);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> load(@Nullable String string){
        glideUrl=new GlideUrl(string);
        return (RequestBuilder2<TranscodeType>)super.load(string);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> apply(@NonNull BaseRequestOptions requestOptions){
        return (RequestBuilder2<TranscodeType>)super.apply(requestOptions);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> transition(@NonNull TransitionOptions<?,? super TranscodeType> transitionOptions){
        return (RequestBuilder2<TranscodeType>)super.transition(transitionOptions);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener){
        return (RequestBuilder2<TranscodeType>)super.listener(requestListener);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener){
        return (RequestBuilder2<TranscodeType>)super.addListener(requestListener);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> errorBuilder){
        return (RequestBuilder2<TranscodeType>)super.error(errorBuilder);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> thumbnailRequest){
        return (RequestBuilder2<TranscodeType>)super.thumbnail(thumbnailRequest);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... thumbnails){
        return (RequestBuilder2<TranscodeType>)super.thumbnail(thumbnails);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> thumbnail(float sizeMultiplier){
        return (RequestBuilder2<TranscodeType>)super.thumbnail(sizeMultiplier);
    }

    @Override
    public RequestBuilder2<TranscodeType> load(@Nullable URL url){
        glideUrl = new GlideUrl(url);
        return (RequestBuilder2<TranscodeType>)super.load(url);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> sizeMultiplier(float sizeMultiplier){
        return (RequestBuilder2<TranscodeType>)super.sizeMultiplier(sizeMultiplier);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean flag){
        return (RequestBuilder2<TranscodeType>)super.useUnlimitedSourceGeneratorsPool(flag);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> useAnimationPool(boolean flag){
        return (RequestBuilder2<TranscodeType>)super.useAnimationPool(flag);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> onlyRetrieveFromCache(boolean flag){
        return (RequestBuilder2<TranscodeType>)super.onlyRetrieveFromCache(flag);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> diskCacheStrategy(@NonNull DiskCacheStrategy strategy){
        return (RequestBuilder2<TranscodeType>)super.diskCacheStrategy(strategy);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> priority(@NonNull Priority priority){
        return (RequestBuilder2<TranscodeType>)super.priority(priority);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> placeholder(@Nullable Drawable drawable){
        return (RequestBuilder2<TranscodeType>)super.placeholder(drawable);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> placeholder(int resourceId){
        return (RequestBuilder2<TranscodeType>)super.placeholder(resourceId);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> fallback(@Nullable Drawable drawable){
        return (RequestBuilder2<TranscodeType>)super.fallback(drawable);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> fallback(int resourceId){
        return (RequestBuilder2<TranscodeType>)super.fallback(resourceId);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> error(@Nullable Drawable drawable){
        return (RequestBuilder2<TranscodeType>)super.error(drawable);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> error(int resourceId){
        return (RequestBuilder2<TranscodeType>)super.error(resourceId);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> theme(@Nullable Resources.Theme theme){
        return (RequestBuilder2<TranscodeType>)super.theme(theme);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> skipMemoryCache(boolean skip){
        return (RequestBuilder2<TranscodeType>)super.skipMemoryCache(skip);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> override(int width,int height){
        return (RequestBuilder2<TranscodeType>)super.override(width,height);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> override(int size){
        return (RequestBuilder2<TranscodeType>)super.override(size);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> signature(@NonNull Key signature){
        return (RequestBuilder2<TranscodeType>)super.signature(signature);
    }

    @NonNull
    @Override
    public <Y> RequestBuilder2<TranscodeType> set(@NonNull Option<Y> option,@NonNull Y value){
        return (RequestBuilder2<TranscodeType>)super.set(option,value);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> decode(@NonNull Class<?> resourceClass){
        return (RequestBuilder2<TranscodeType>)super.decode(resourceClass);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> encodeFormat(@NonNull Bitmap.CompressFormat format){
        return (RequestBuilder2<TranscodeType>)super.encodeFormat(format);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> encodeQuality(int quality){
        return (RequestBuilder2<TranscodeType>)super.encodeQuality(quality);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> frame(long frameTimeMicros){
        return (RequestBuilder2<TranscodeType>)super.frame(frameTimeMicros);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> format(@NonNull DecodeFormat format){
        return (RequestBuilder2<TranscodeType>)super.format(format);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> disallowHardwareConfig(){
        return (RequestBuilder2<TranscodeType>)super.disallowHardwareConfig();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> downsample(@NonNull DownsampleStrategy strategy){
        return (RequestBuilder2<TranscodeType>)super.downsample(strategy);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> timeout(int timeoutMs){
        return (RequestBuilder2<TranscodeType>)super.timeout(timeoutMs);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> optionalCenterCrop(){
        return (RequestBuilder2<TranscodeType>)super.optionalCenterCrop();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> centerCrop(){
        return (RequestBuilder2<TranscodeType>)super.centerCrop();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> optionalFitCenter(){
        return (RequestBuilder2<TranscodeType>)super.optionalFitCenter();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> fitCenter(){
        return (RequestBuilder2<TranscodeType>)super.fitCenter();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> optionalCenterInside(){
        return (RequestBuilder2<TranscodeType>)super.optionalCenterInside();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> centerInside(){
        return (RequestBuilder2<TranscodeType>)super.centerInside();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> optionalCircleCrop(){
        return (RequestBuilder2<TranscodeType>)super.optionalCircleCrop();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> circleCrop(){
        return (RequestBuilder2<TranscodeType>)super.circleCrop();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> transform(@NonNull Transformation<Bitmap> transformation){
        return (RequestBuilder2<TranscodeType>)super.transform(transformation);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> transform(@NonNull Transformation<Bitmap>... transformations){
        return (RequestBuilder2<TranscodeType>)super.transform(transformations);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> transforms(@NonNull Transformation<Bitmap>... transformations){
        return (RequestBuilder2<TranscodeType>)super.transforms(transformations);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> optionalTransform(@NonNull Transformation<Bitmap> transformation){
        return (RequestBuilder2<TranscodeType>)super.optionalTransform(transformation);
    }

    @NonNull
    @Override
    public <Y> RequestBuilder2<TranscodeType> optionalTransform(
            @NonNull Class<Y> resourceClass,@NonNull Transformation<Y> transformation)
    {
        return (RequestBuilder2<TranscodeType>)super.optionalTransform(resourceClass,transformation);
    }

    @NonNull
    @Override
    public <Y> RequestBuilder2<TranscodeType> transform(
            @NonNull Class<Y> resourceClass,@NonNull Transformation<Y> transformation)
    {
        return (RequestBuilder2<TranscodeType>)super.transform(resourceClass,transformation);
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> dontTransform(){
        return (RequestBuilder2<TranscodeType>)super.dontTransform();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> dontAnimate(){
        return (RequestBuilder2<TranscodeType>)super.dontAnimate();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> lock(){
        return (RequestBuilder2<TranscodeType>)super.lock();
    }

    @NonNull
    @Override
    public RequestBuilder2<TranscodeType> autoClone(){
        return (RequestBuilder2<TranscodeType>)super.autoClone();
    }

    public RequestBuilder2<TranscodeType> onProgressListener(OnGlideProgressListener listener){
        this.glideProgressPack=new GlideProgressPack(listener);
        return this;
    }

    public RequestBuilder2<TranscodeType> onProgressListener(OnGlideProgressListener listener,int progressInterval){
        this.glideProgressPack=new GlideProgressPack(listener,progressInterval);
        return this;
    }

    /**
     * 附加到ImageView上
     * @param imageView
     * @return
     */
    public ImageTarget<TranscodeType> attach(ImageView imageView){
        return into(new ImageTarget<TranscodeType>(imageView,pack()));
    }


    public <Y extends Target<TranscodeType>> GlideTarget<Y,TranscodeType> attach(Y target){
        return into(new GlideTarget<Y,TranscodeType>(target,pack()));
    }
    
    public <Y extends Target<TranscodeType>> GlideTarget<Y,TranscodeType> attachAsync(Y target){
        return into(new GlideTarget<Y,TranscodeType>(target,pack()),null,Executors.directExecutor());
    }

    /**
     * 添加进度监听到列表中
     * @return
     */
    private String pack(){
        if(glideUrl!=null&&glideProgressPack!=null){
            String glideTag=glideUrl.toStringUrl();
            GlidePack.addListener(glideTag,glideProgressPack);
            return glideTag;
        }
        return null;
    }
}
