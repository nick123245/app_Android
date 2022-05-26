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
        try {        
            ImageDecoder.Source source;
            source = ImageDecoder.createSource(getResources(), R.drawable.ic_splash);

            Drawable drawable;
            drawable = ImageDecoder.decodeDrawable(source);
            imageView.setImageDrawable(drawable);

                ((AnimatedImageDrawable) drawable).start();
                Toast.makeText(getApplicationContext(),
                        "Animation started",
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
