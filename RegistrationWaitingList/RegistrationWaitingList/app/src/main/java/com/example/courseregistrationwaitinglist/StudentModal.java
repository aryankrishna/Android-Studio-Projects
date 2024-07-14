package com.example.courseregistrationwaitinglist;

public class StudentModal {

    private String studentName;
    private String classPriority;
    private String cwid;
    private String courseName;
    private int id;

    // creating getter and setter methods
    public String getStudentName() { return studentName; }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getClassPriority()
    {
        return classPriority;
    }

    public void setClassPriority(String classPriority)
    {
        this.classPriority = classPriority;
    }

    public String getCwid() { return cwid; }

    public void setCwid(String cwid)
    {
        this.cwid = cwid;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void
    setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public StudentModal(String studentName,
                       String classPriority,
                       String cwid,
                       String courseName)
    {
        this.studentName = studentName;
        this.classPriority = classPriority;
        this.cwid = cwid;
        this.courseName = courseName;
    }
}

