package com.glide.progress;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.request.FutureTarget;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Glide.init(this, new GlideBuilder());
//        GlideInitialize.initialize(this);
        try {
            Class clazz = Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl");
            Object obj =
                    clazz.getDeclaredConstructor(Context.class).newInstance(getApplicationContext());
            Log.e("noah", obj.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                FutureTarget<File> downloadOnly = Glide.with(MainActivity.this)
                        .load("https://s1.dgtle.com/dgtle_img/article/2022/11/28/a1bc4202211282218531417.jpeg")
                        .downloadOnly(1, 1);
                try {
                    Log.e("noah", downloadOnly.get().getAbsolutePath());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
