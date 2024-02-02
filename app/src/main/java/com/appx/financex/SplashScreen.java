package com.appx.financex;

import androidx.appcompat.app.AppCompatActivity;
import com.appx.financex.databinding.ActivitySplashScreenBinding;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}