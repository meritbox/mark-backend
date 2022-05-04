package com.markbackend.dao;

import com.markbackend.pojo.StudentGrade;
import com.markbackend.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherDao {
    List<Teacher> findAll();

    Teacher login(String logn);

    int setRate(double rate, String cno);

    int updateStudentgrade(StudentGrade studentGrade);

    int calGrade(String cno);

}
