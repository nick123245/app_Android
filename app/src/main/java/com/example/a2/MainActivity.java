package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.splash);
        loadGif(imageView);
    }
    
    private void loadGif(ImageView iv)  {
        try {        
            ImageDecoder.Source source;
            source = ImageDecoder.createSource(getResources(), R.drawable.ic_splash);

            Drawable drawable;
            drawable = ImageDecoder.decodeDrawable(source);
            iv.setImageDrawable(drawable);
            if (drawable instanceof AnimatedImageDrawable) {
                ((AnimatedImageDrawable) drawable).start();
                Toast.makeText(getApplicationContext(),
                        "Animation started",
                        Toast.LENGTH_LONG).show();
        }
            else Toast.makeText(getApplicationContext(),
                    "Animation not working!!!",
                    Toast.LENGTH_LONG).show();
            }
                 catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),
                        "IOException: \n" + e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        
    }
}
