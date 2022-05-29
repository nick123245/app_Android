package com.example.sensors;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.splash);
        loadGif(imageView);
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    private void loadGif(ImageView iv)  {
        try {        
            ImageDecoder.Source source = ImageDecoder.createSource(getResources(), R.drawable.ic_splash);

            Drawable drawable = ImageDecoder.decodeDrawable(source);
            iv.setImageDrawable(drawable);
                ((AnimatedImageDrawable) drawable).start();
                Toast.makeText(getApplicationContext(),
                        R.string.text1,
                        Toast.LENGTH_LONG).show();
        
            }
                catch (IOException exception) {
                exception.printStackTrace();
                Toast.makeText(getApplicationContext(),
                        "IOException: \n" + exception.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        
    }
}
