package com.example.loginandroid_29_09_2023.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageLoader {
    private String url;
    private ImageView imageView;
    public ImageLoader(Builder builder) {
        this.url = builder.url;
        this.imageView = builder.imageView;
    }
    static Bitmap bitmap;
    public void load(){
        new Thread(() ->{
            try {
                URL url = new URL(this.url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream input = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(input);

                // Actualizar el ImageView en el hilo principal
                imageView.post(() -> imageView.setImageBitmap(bitmap));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }).start();
    }

    public static class Builder{
        private String url;
        private ImageView imageView;
        private boolean generateImage = false;

        public Builder(String url, ImageView imageView){
            this.url = url;
            this.imageView = imageView;
        }

        public Builder generateImage() {
            this.generateImage = true;
            return this;
        }

        public ImageLoader build(){
            return new ImageLoader (this);
        }

    }
}

