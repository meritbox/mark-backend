package com.markbackend.controller;

import com.markbackend.pojo.LoginBody;
import com.markbackend.pojo.StudentGrade;
import com.markbackend.pojo.Teacher;
import com.markbackend.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/findAll")
    public List<Teacher> findALL(){return teacherService.findAll();}

    @PostMapping("/login")
    public int login(@RequestBody LoginBody loginBody){
        return teacherService.login(loginBody.getLogn(), loginBody.getPwd());
    }

    @GetMapping("/setRate/{rate}/{cno}")
    public boolean setRate(@PathVariable double rate,@PathVariable String cno){
        if(teacherService.setRate(rate, cno)){
            return teacherService.calGrade(cno);
        }
        else {
            return false;
        }
    }

    @PostMapping("/updateStuGrade")
    public boolean updateStuGrade(@RequestBody StudentGrade studentGrade){
        if(teacherService.updateStudentgrade(studentGrade)){
            return teacherService.calGrade(studentGrade.getCno());
        }
        else{
            return false;
        }
    }
}
