package com.example.who_wants_to_be_a_millionare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class question_11 extends AppCompatActivity {

    // Define your question, options, and correct answer here
    private String question = "11) What year did Lewis Hamilton win his first Formula 1 World Championship title?";
    private String[] options = {"2007" , "2008" , "2009" , "2010"};
    private int correctAnswerIndex = 1; // Index of correct answer in options array

    private RadioGroup radioGroup;
    private TextView earnedAmountTextView;
    private int earnedAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question11);

        // Initialize UI elements
        radioGroup = findViewById(R.id.radio_group_options);
        earnedAmountTextView = findViewById(R.id.text_view_earned_amount);

        // Retrieve the earned amount from the previous question
        earnedAmount = getIntent().getIntExtra("earnedAmount", 0); // Default to 0 if not provided

        // Update the earned amount TextView
        earnedAmountTextView.setText("You've Earned: $" + earnedAmount);

        // Set question text and option texts
        TextView textViewQuestion = findViewById(R.id.text_view_question);
        textViewQuestion.setText(question);

        for (int i = 0; i < options.length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setTextColor(getResources().getColor(R.color.textcol));
            radioButton.setId(i); // Set unique ID for each RadioButton
            radioButton.setText(options[i]);
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RadioButton selectedRadioButton = (RadioButton) view;
                    for (int j = 0; j < radioGroup.getChildCount(); j++) {
                        RadioButton rb = (RadioButton) radioGroup.getChildAt(j);
                        rb.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    }
                    selectedRadioButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                }
            });
            radioGroup.addView(radioButton);
        }
    }

    public void checkAnswer(View view) {
        int selectedOptionId = radioGroup.getCheckedRadioButtonId();
        if (selectedOptionId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedOptionId);
            String selectedOption = selectedRadioButton.getText().toString();
            if (options[correctAnswerIndex].equals(selectedOption)) {
                if (earnedAmount == 0) {
                    earnedAmount = 100;
                } else {
                    earnedAmount *= 2;
                }
                showToast("Correct! You earned $" + earnedAmount); // Display message for current question's earnings

                // Check if all questions were answered correctly
                if (earnedAmount == 51200) { // Adjust this value according to the total possible winnings
                    // Move to the winner activity
                    moveToWinnerActivity();
                } else {
                    // Move to the loser activity
                    moveToLoserActivity();
                }
            } else {
                // Incorrect answer
                showToast("Incorrect! Try again.");
                // Move to the loser activity
                moveToLoserActivity();
            }
        } else {
            showToast("Please select an option.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void moveToWinnerActivity() {
        Intent intent = new Intent(this, winner.class);
        intent.putExtra("earnedAmount", earnedAmount);
        startActivity(intent);
        finish(); // Finish current activity to prevent going back
    }

    private void moveToLoserActivity() {
        Intent intent = new Intent(this, loser.class);
        intent.putExtra("earnedAmount", earnedAmount);
        startActivity(intent);
        finish(); // Finish current activity to prevent going back
    }
}