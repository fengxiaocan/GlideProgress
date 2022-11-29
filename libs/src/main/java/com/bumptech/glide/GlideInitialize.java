package com.bumptech.glide;

import android.content.Context;

import androidx.annotation.NonNull;

public final class GlideInitialize {
    public static void initialize(Context context) {
        initialize(context, new GlideBuilder());
    }

    public static void initialize(@NonNull Context context, @NonNull GlideBuilder builder) {
        Glide.init(context, builder);
    }
}
