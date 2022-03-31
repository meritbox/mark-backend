package com.markbackend.controller;

import com.markbackend.pojo.ClassRecord;
import com.markbackend.pojo.Clazz;
import com.markbackend.service.ClazzService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    ClazzService clazzService;

    @GetMapping("/findAll")
    public List<Clazz> findAll(){
        return clazzService.findAll();
    }

    @GetMapping("/findByCno/{cno}")
    public List<ClassRecord> findClazzByCno(@PathVariable("cno") String cno){
        return clazzService.findClazzByCno(cno);
    }
    @PostMapping("/update")
    public boolean updateClazzByCno(@RequestBody Clazz clazz){
        return clazzService.updateClazzByCno(clazz);
    }
    @PostMapping("/add")
    public boolean addClazz(@RequestBody Clazz clazz){
        return clazzService.addClazz(clazz);
    }
    @DeleteMapping("/delete/{cno}")
    public boolean deleteClazzByCno(@PathVariable("cno") String cno){
        return clazzService.deleteClazzByCno(cno);
    }
    @GetMapping("/findClazzChoosable/{sno}")
    public List<Clazz> findClazzChoosable(@PathVariable("sno") String sno){
        return clazzService.findClazzChoosable(sno);
    }

}
