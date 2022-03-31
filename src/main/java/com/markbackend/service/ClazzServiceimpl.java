package com.markbackend.service;

import com.markbackend.dao.ClazzDao;
import com.markbackend.pojo.ClassRecord;
import com.markbackend.pojo.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceimpl implements ClazzService{
    @Autowired
    ClazzDao clazzDao;
    @Override
    public List<Clazz> findAll() {
        return clazzDao.findAll();
    }

    @Override
    public List<ClassRecord> findClazzByCno(String cno) {
        return clazzDao.findClazzByCno(cno);
    }

    @Override
    public boolean deleteClazzByCno(String cno) {
        if(cno == null) return false;
        int i = clazzDao.removeClazzByCno(cno);
        return (i > 0)? true: false;

    }

    @Override
    public boolean updateClazzByCno(Clazz clazz) {
        if(clazz == null) return false;
        int i = clazzDao.updateClazzByCno(clazz);
        return (i > 0)? true: false;
    }

    @Override
    public boolean addClazz(Clazz clazz) {
        if(clazz == null) return false;
        int i = clazzDao.addClazz(clazz);
        return (i > 0)? true:false;
    }

    @Override
    public List<Clazz> findClazzChoosable(String sno) {
        return clazzDao.findClazzChoosable(sno);
    }
}
