package com.example.splashviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoviewId);

        String video = "android.resources//"+ getPackageName() + R.raw.life;
        Uri uri = Uri.parse(video);

        videoView.setVideoURI(uri);

        mediaController = new MediaController(this);

        videoView.setMediaController(mediaController);

        videoView.start();

    }
}
