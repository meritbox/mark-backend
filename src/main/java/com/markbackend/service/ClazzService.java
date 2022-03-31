package com.markbackend.service;

import com.markbackend.pojo.ClassRecord;
import com.markbackend.pojo.Clazz;
import com.markbackend.pojo.Student;

import java.util.List;

public interface ClazzService {
    List<Clazz> findAll();

    List<ClassRecord> findClazzByCno(String cno);

    boolean deleteClazzByCno(String cno);

    boolean updateClazzByCno(Clazz clazz);

    boolean addClazz(Clazz clazz);

    List<Clazz> findClazzChoosable(String sno);


}
