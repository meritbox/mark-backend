package com.markbackend.service;

import com.markbackend.pojo.StudentGrade;
import com.markbackend.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    int login(String logn, String pwd);

    boolean setRate(double rate, String cno);

    boolean updateStudentgrade(StudentGrade stuGrade);

    boolean calGrade(String cno);

}
