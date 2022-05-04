package com.markbackend.service;

import com.markbackend.dao.StudentDao;
import com.markbackend.dao.TeacherDao;
import com.markbackend.pojo.Student;
import com.markbackend.pojo.StudentGrade;
import com.markbackend.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public int login(String logn, String pwd) {
        if ("SYSTEM".equals(logn) && "SYSTEM".equals(pwd)) return 2;
        Teacher teacher = teacherDao.login(logn);
        if (teacher == null) return 0;
        if (!teacher.getPswd().equals(pwd)) return 0;
        else return 1;
    }

    @Override
    public boolean setRate(double rate, String cno) {
        int i = teacherDao.setRate(rate, cno);
        return (i > 0) ? true : false;
    }

    @Override
    public boolean updateStudentgrade(StudentGrade stuGrade) {
        if (stuGrade == null) return false;
        List<Student> students = studentDao.findAll();
        boolean isexiststu = false;

        for (Student s : students) {
            if (s.getCno().equals(stuGrade.getSno())) isexiststu = true;
        }
        if (!isexiststu) return false;

        int i = teacherDao.updateStudentgrade(stuGrade);
        return (i > 0) ? true : false;
    }

    @Override
    public boolean calGrade(String cno) {
        int i = teacherDao.calGrade(cno);
        return (i > 0) ? true : false;
    }
}
