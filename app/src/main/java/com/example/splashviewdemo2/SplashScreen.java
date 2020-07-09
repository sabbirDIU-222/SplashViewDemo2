package com.example.splashviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private int pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        inOne();
    }

    public void inOne(){
        progressBar = findViewById(R.id.proressbarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    progress();
                    secondActivity();
            }
        });
        thread.start();
    }

    public void progress(){
        for(pro = 1;pro<=500; pro = pro+10){
            try {
                Thread.sleep(500);
                progressBar.setProgress(pro);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void secondActivity(){
        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
