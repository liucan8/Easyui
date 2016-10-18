package com.lc;

import com.mapper.UserMapper;
import com.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
@Repository
public class MvcDao {
    @Autowired
    UserMapper mapper;
    @Autowired
    private GradeMapper gradeMapper;

    public String hello(){
        return "hello lc";
    }

    public List<User> getUserList(User user){
        return mapper.findUserList(user);
    }

    public String findUser(String name){
        return mapper.findUserByName(name);
    }
    public void saveGrade(Grade grade){
        gradeMapper.saveGrade(grade);
    }
    public void saveUsers(User user){
        mapper.saveUsers(user);
    }
    public void saveUser(Grade grade){
        mapper.saveUser(grade);
    }
    public String checkUser(User user){
        return mapper.checkUser(user);
    }

    public void saveOne()throws Exception{
        mapper.saveOne("liucan01","1234");
    }
    public void delRow(int userId){
        mapper.delRow(userId);
    }
}
