package com.lc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
@Service
public class MvcService {
    @Autowired
    private MvcDao mvcDao;

    public String service()
    {
        return mvcDao.hello();
    }

    public List<User> findUserList(User user)
    {
        return mvcDao.getUserList(user);
    }

    public String findUser(String name)
    {
        return mvcDao.findUser(name);
    }
    public void saveUser(User user){
        mvcDao.saveUsers(user);
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class })
    public void saveGrade(Grade grade) throws Exception{
        mvcDao.saveUser(grade);
        //mvcDao.saveGrade(grade);
        //throw new Exception("New Exception...");
    }
    public String checkUser(User user){
        return mvcDao.checkUser(user);
    }

    public String getData(){
        StringBuffer data = new StringBuffer();
        data.append("{'total':1,'rows':[{'userName':'lc','userAge':'14','userId':'1','comment':'test','tips':'pp'}]");
        return data.toString();
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class })
    public void saveOne()throws Exception{
        mvcDao.saveOne();
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class })
    public void delRow(int userId){
        mvcDao.delRow(userId);
    }

}
