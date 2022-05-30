package com.example.sensors;

import androidx.annotation.RequiresApi;
import android.app.Activity;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    Button button1;
    Button button2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        ImageView imageView = findViewById(R.id.splash);
        
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button1:
                        loadGif1(imageView);
                        break;
                    case R.id.button2:
                        loadGif2(imageView);
                        break;
                }
            }

        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    private void loadGif1(ImageView iv)  {
        try {        
            ImageDecoder.Source source = ImageDecoder.createSource(getResources(), R.drawable.ic_splash);

            Drawable drawable = ImageDecoder.decodeDrawable(source);
            iv.setImageDrawable(drawable);
                ((AnimatedImageDrawable) drawable).start();
                Toast.makeText(getApplicationContext(),
                    "Animation Cynosure started",
                    Toast.LENGTH_LONG).show();
        
            }
                catch (IOException exception) {
                exception.printStackTrace();
                Toast.makeText(getApplicationContext(),
                        "IOException: \n" + exception.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
    }
        @RequiresApi(api = Build.VERSION_CODES.P)
        private void loadGif2(ImageView iv) {
        try {
            ImageDecoder.Source source =
                    ImageDecoder.createSource(getResources(), R.drawable.ic_splash2);
            Drawable drawable = ImageDecoder.decodeDrawable(source);
            iv.setImageDrawable(drawable);
            ((AnimatedImageDrawable) drawable).start();
            Toast.makeText(getApplicationContext(),
                    "Animation Abstract started",
                    Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),
                    "IOException: \n" + e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }
}
