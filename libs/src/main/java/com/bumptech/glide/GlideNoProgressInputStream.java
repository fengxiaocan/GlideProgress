package com.bumptech.glide;

import androidx.annotation.NonNull;

import java.io.FilterInputStream;
import java.io.InputStream;

public class GlideNoProgressInputStream extends FilterInputStream{

    @NonNull
    public static InputStream obtain(@NonNull InputStream other){
        return new GlideNoProgressInputStream(other);
    }

    private GlideNoProgressInputStream(@NonNull InputStream in){
        super(in);
    }
}

