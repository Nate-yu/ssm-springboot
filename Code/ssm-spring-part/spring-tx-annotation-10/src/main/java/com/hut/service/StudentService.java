package com.hut.service;

import com.hut.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional // 在类上加事务注解，类中所有方法都是事务
@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;

    @Transactional(timeout = 3, rollbackFor = Exception.class, noRollbackFor = RuntimeException.class,
            isolation = Isolation.READ_COMMITTED)
    public void changeInfo(){
        studentDao.updateAgeById(100,1);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        studentDao.updateNameById("test1",1);
    }

    @Transactional(readOnly = true)
    public void getStudentInfo() {
        // 只查询获取学生信息，不修改
    }

    /**
     * 声明两个独立修改数据库的事务业务方法
     * REQUIRED: 父方法有事务就加入到父方法的事务中
     * REQUIRES_NEW: 每次都新开启一个事务
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeAge(){
        studentDao.updateAgeById(998,1);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName(){
        studentDao.updateNameById("yubin",1);
        int i = 1/0;
    }
}
