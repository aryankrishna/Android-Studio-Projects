package com.example.who_wants_to_be_a_millionare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    // Splash screen timeout duration
    private static final int SPLASH_TIMEOUT = 3000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Using a Handler to delay the transition to the Authentication Activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the Authentication Activity
                Intent intent = new Intent(MainActivity.this, question_1.class);
                startActivity(intent);

                // Close this activity
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}