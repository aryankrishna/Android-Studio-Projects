package com.example.who_wants_to_be_a_millionare;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        // Retrieve the earned amount from the intent
        int earnedAmount = getIntent().getIntExtra("earnedAmount", 0);

        // Display the earned amount in the TextView
        TextView textViewAmount = findViewById(R.id.text_view_earned_amount);
        textViewAmount.setText("Congratulations!\nYou have won: $" + earnedAmount);
    }
}
