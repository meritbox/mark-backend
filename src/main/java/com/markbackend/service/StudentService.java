package com.markbackend.service;

import com.markbackend.pojo.ClazzAvg;
import com.markbackend.pojo.Student;
import com.markbackend.pojo.StudentGrade;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    boolean deleteStudentByCno(String cno);

    boolean updateStudentByCno(Student stu);

    int login(String logn , String pwd);

    boolean addStudent(Student stu);

    List<StudentGrade> findGradebyCno(String cno);

    boolean addStudentgrade(StudentGrade stuGrade);

    Student findStuBylogn(String logn);

    List<StudentGrade> findGradeMarked(String cno);

    boolean deleteStudentGrade(StudentGrade studentGrade);

    List<StudentGrade> findGradebyClass(String cno);

    List<ClazzAvg> findAvgMark();
}
