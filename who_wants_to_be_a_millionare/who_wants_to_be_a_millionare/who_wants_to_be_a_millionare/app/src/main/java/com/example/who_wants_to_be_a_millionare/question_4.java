package com.example.who_wants_to_be_a_millionare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class question_4 extends AppCompatActivity {

    // Define your question, options, and correct answer here
    private String question = "4) Which circuit hosts the prestigious Monaco Grand Prix?";
    private String[] options = {"Silverstone Circuit" , "Circuit de Barcelona-Catalunya" , "Circuit de Spa-Francorchamps" , "Circuit de Monaco"};
    private int correctAnswerIndex = 3; // Index of correct answer in options array

    private RadioGroup radioGroup;
    private TextView earnedAmountTextView;
    private int earnedAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        // Initialize UI elements
        radioGroup = findViewById(R.id.radio_group_options);
        earnedAmountTextView = findViewById(R.id.text_view_earned_amount);

        // Retrieve the earned amount from the previous question
        earnedAmount = getIntent().getIntExtra("earnedAmount", 0); // Default to 0 if not provided

        // Update the earned amount TextView
        earnedAmountTextView = findViewById(R.id.text_view_earned_amount);
        earnedAmountTextView.setText("Achieved: $" + earnedAmount);

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
            } else {
                // Incorrect answer
                showToast("Incorrect! Try again.");
            }

            // Move to the next question and pass the updated earned amount
            Intent intent = new Intent(this, question_5.class);
            intent.putExtra("earnedAmount", earnedAmount);
            startActivity(intent);
        } else {
            showToast("Please select an option.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
