package com.example.courseregistrationwaitinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;


public class UpdateStudentActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText StudentNameEdt, CourseNameEdt, ClassPriorityEdt, StudentCwidEdt;
    private Button updateCourseBtn,deleteCourseBtn;
    private DBHandler dbHandler;
    String StudentName, CourseName, ClassPriority, StudentCwid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        // initializing all our variables.
        StudentNameEdt = findViewById(R.id.idEdtCourseName);
        CourseNameEdt = findViewById(R.id.idEdtCourseDuration);
        ClassPriorityEdt = findViewById(R.id.idEdtCourseTracks);
        StudentCwidEdt = findViewById(R.id.idEdtCourseDescription);
        updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);
        deleteCourseBtn = findViewById(R.id.idBtnDelete);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateStudentActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        StudentName = getIntent().getStringExtra("name");
        CourseName = getIntent().getStringExtra("cwid");
        ClassPriority = getIntent().getStringExtra("priority");
        StudentCwid = getIntent().getStringExtra("coursename");

        // setting data to edit text
        // of our update activity.
        StudentNameEdt.setText(StudentName);
        CourseNameEdt.setText(CourseName);
        ClassPriorityEdt.setText(ClassPriority);
        StudentCwidEdt.setText(StudentCwid);

        // adding on click listener to our update course button.
        updateCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.updateCourse(StudentName, StudentNameEdt.getText().toString(), CourseNameEdt.getText().toString(), ClassPriorityEdt.getText().toString(), StudentCwidEdt.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateStudentActivity.this, "Course Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateStudentActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        // adding on click listener for delete button to delete our course.
        deleteCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                dbHandler.deleteCourse(StudentName);
                Toast.makeText(UpdateStudentActivity.this, "Deleted the course", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateStudentActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
