package com.markbackend.controller;

import com.markbackend.pojo.ClazzAvg;
import com.markbackend.pojo.LoginBody;
import com.markbackend.pojo.Student;
import com.markbackend.pojo.StudentGrade;
import com.markbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @DeleteMapping("/delete/{cno}")
    public boolean delete(@PathVariable("cno") String cno){
        return studentService.deleteStudentByCno(cno);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Student stu){
        return studentService.updateStudentByCno(stu);
    }
    @PostMapping("/login")
    public int login(@RequestBody LoginBody loginBody){
        return studentService.login(loginBody.getLogn(),loginBody.getPwd());
    }
    @PostMapping("/add")
    public boolean addStudent(@RequestBody Student stu){
        return studentService.addStudent(stu);
    }

    @GetMapping("/getgrade/{cno}")
    public List<StudentGrade> findgradeByCno(@PathVariable("cno") String cno){
        return studentService.findGradebyCno(cno);
    }

    @PostMapping("/addStuGrade")
    public boolean addStudentGrade(@RequestBody StudentGrade studentGrade){
        return studentService.addStudentgrade(studentGrade);
    }
    @GetMapping("/findStuBylogn/{logn}")
    public Student findStuBylogn(@PathVariable("logn") String logn){
        return studentService.findStuBylogn(logn);
    }
    @GetMapping("/findGradeMarked/{cno}")
    public List<StudentGrade> findGradeMarked(@PathVariable("cno") String cno){
        return studentService.findGradeMarked(cno);
    }
    @PostMapping("/deleteStuGrade")
    public boolean deleteStuGrade(@RequestBody StudentGrade studentGrade){

        return studentService.deleteStudentGrade(studentGrade);
    }
    @GetMapping("/getgradebyclass/{cno}")
    public List<StudentGrade> getGradeByClass(@PathVariable("cno") String cno){
        return studentService.findGradebyClass(cno);
    }
    @GetMapping("/findAvgMark")
    public List<ClazzAvg> getClazzAvg(){
        return studentService.findAvgMark();
    }
}
