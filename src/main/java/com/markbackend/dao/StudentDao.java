package com.markbackend.dao;

import com.markbackend.pojo.Clazz;
import com.markbackend.pojo.ClazzAvg;
import com.markbackend.pojo.Student;
import com.markbackend.pojo.StudentGrade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    List<Student> findAll();

    int removeStudentByCno(String cno);

    int updateStudentByCno(Student stu);

    Student login(String logn);

    int addStudent(Student stu);

    List<StudentGrade> findGradebyCno(String cno);

    int addStudentgrade(StudentGrade stuGrade);

    int removeStudentGrade(StudentGrade studentGrade);

    List<StudentGrade> findGradebyClass(String cno);

    List<ClazzAvg> findAvgMark();


}
