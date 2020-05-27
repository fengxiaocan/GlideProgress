package com.bumptech.glide;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

import java.io.InputStream;

import static com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.TIMEOUT;

/**
 * An {@link com.bumptech.glide.load.model.ModelLoader} for translating {@link
 * com.bumptech.glide.load.model.GlideUrl} (http/https URLS) into {@link InputStream} data.
 */
// Public API.
@SuppressWarnings("WeakerAccess")
public class HttpGlideUrlLoader2 implements ModelLoader<GlideUrl,InputStream>{

    @Nullable
    private final ModelCache<GlideUrl,GlideUrl> modelCache;

    public HttpGlideUrlLoader2(){
        this(null);
    }

    public HttpGlideUrlLoader2(@Nullable ModelCache<GlideUrl,GlideUrl> modelCache){
        this.modelCache=modelCache;
    }

    @Override
    public LoadData<InputStream> buildLoadData(
            @NonNull GlideUrl model,int width,int height,@NonNull Options options)
    {
        // GlideUrls memoize parsed URLs so caching them saves a few object instantiations and time
        // spent parsing urls.
        GlideUrl url=model;
        if(modelCache!=null){
            url=modelCache.get(model,0,0);
            if(url==null){
                modelCache.put(model,0,0,model);
                url=model;
            }
        }
        int timeout=options.get(TIMEOUT);
        return new LoadData<>(url,new HttpUrlFetcher2(url,timeout));
    }

    @Override
    public boolean handles(@NonNull GlideUrl model){
        return true;
    }

    public static class Factory implements ModelLoaderFactory<GlideUrl,InputStream>{
        private final ModelCache<GlideUrl,GlideUrl> modelCache=new ModelCache<>(500);

        @NonNull
        @Override
        public ModelLoader<GlideUrl,InputStream> build(MultiModelLoaderFactory multiFactory){
            return new HttpGlideUrlLoader2(modelCache);
        }

        @Override
        public void teardown(){
            // Do nothing.
        }
    }

}
