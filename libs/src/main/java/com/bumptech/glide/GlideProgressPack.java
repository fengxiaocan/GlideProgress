package com.bumptech.glide;

class GlideProgressPack implements OnGlideProgressListener{
    private final OnGlideProgressListener listener;
    private final int progressInterval;
    private static final int DEFAULT_INTERVAL=500;
    private volatile long lastTime=0;

    public GlideProgressPack(OnGlideProgressListener listener){
        this(listener,DEFAULT_INTERVAL);
    }

    public GlideProgressPack(OnGlideProgressListener listener,int progressInterval){
        this.listener=listener;
        this.progressInterval=progressInterval;
    }

    public synchronized void onProgress(final long totalLength,final long sofarLength){
        if(totalLength>0&&System.currentTimeMillis()-lastTime >= progressInterval){
            float v=sofarLength*1F/totalLength;
            onProgress(sofarLength*1F/totalLength);
            lastTime=System.currentTimeMillis();
        }
    }

    @Override
    public void onProgress(float progress){
        listener.onProgress(progress);
    }
}
