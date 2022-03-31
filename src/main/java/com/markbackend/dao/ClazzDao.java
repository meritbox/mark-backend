package com.markbackend.dao;

import com.markbackend.pojo.ClassRecord;
import com.markbackend.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface ClazzDao {
    List<Clazz> findAll();
    List<ClassRecord> findClazzByCno(String cno);
    int removeClazzByCno(String cno);
    int updateClazzByCno(Clazz clazz);
    int addClazz(Clazz clazz);
    List<Clazz> findClazzChoosable(String sno);

}
