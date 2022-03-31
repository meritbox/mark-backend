package com.markbackend.service;

import com.markbackend.dao.StudentDao;
import com.markbackend.pojo.Clazz;
import com.markbackend.pojo.ClazzAvg;
import com.markbackend.pojo.Student;
import com.markbackend.pojo.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public boolean deleteStudentByCno(String cno) {
        if(cno == null) return false;
        int i = studentDao.removeStudentByCno(cno);
        return (i > 0)? true : false;
    }

    @Override
    public boolean updateStudentByCno(Student stu) {
        if(stu.getLogn() == "SYSTEM") return false;
        int i = studentDao.updateStudentByCno(stu);
        return (i > 0)? true : false;
    }

    @Override
    public int login(String logn, String pwd) {
        if("SYSTEM".equals(logn) && "SYSTEM".equals(pwd)) return 2;
        Student stu = studentDao.login(logn);
        if(stu == null) return 0;
        if(!stu.getPswd().equals(pwd)) return 0;
        else return 1;
    }

    @Override
    public boolean addStudent(Student stu) {
        if(stu == null || stu.getCno().equals("SYSTEM")) return false;
        int i = studentDao.addStudent(stu);
        return (i > 0)? true : false;
    }

    @Override
    public List<StudentGrade> findGradebyCno(String cno) {
        return studentDao.findGradebyCno(cno);

    }

    @Override
    public boolean addStudentgrade(StudentGrade stuGrade) {
        if(stuGrade == null) return false;
        List<Student> students = studentDao.findAll();
        boolean isexiststu = false;

        for(Student s : students){
            if(s.getCno().equals(stuGrade.getSno())) isexiststu = true;
        }
        if(!isexiststu) return false;

        int i = studentDao.addStudentgrade(stuGrade);
        return (i > 0)? true : false;
    }

    @Override
    public Student findStuBylogn(String logn) {
        return studentDao.login(logn);
    }
    @Override
    public List<StudentGrade> findGradeMarked(String cno){
        List<StudentGrade> grades = studentDao.findGradebyCno(cno);


        for(int i = 0 ; i < grades.size();i++){
            if(grades.get(i).getGrade() == -1){
                grades.remove(i);
            }
        }

        return grades;
    }

    @Override
    public boolean deleteStudentGrade(StudentGrade studentGrade) {
        int i = studentDao.removeStudentGrade(studentGrade);
        return (i > 0) ? true : false;
    }

    @Override
    public List<StudentGrade> findGradebyClass(String cno) {
        return studentDao.findGradebyClass(cno);
    }

    @Override
    public List<ClazzAvg> findAvgMark() {
        List<ClazzAvg> avgMark = studentDao.findAvgMark();
        for(ClazzAvg cl : avgMark){
            System.out.println(cl);
        }
        return avgMark;
    }


}
