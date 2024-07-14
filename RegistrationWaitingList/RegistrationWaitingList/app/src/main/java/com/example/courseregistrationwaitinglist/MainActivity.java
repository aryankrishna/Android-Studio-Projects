package com.example.courseregistrationwaitinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onAddClick(View view) {
        Intent intent = new Intent(this, AddStudents.class);
        startActivity(intent);
    }
    public void onViewClick(View view) {
        Intent intent = new Intent(this, ViewStudents.class);
        startActivity(intent);
    }

    public static class StudentModal {
    }
}