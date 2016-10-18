package com.mapper;

import com.lc.Grade;
import com.lc.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface UserMapper {

    public List<User> findUserList(User user);

    public String findUserByName(String name);

    public void saveUser(Grade grade);

    public void saveUsers(User user);

    public String checkUser(User user);

    public void saveOne(@Param("userName") String userName,@Param("passWord") String passWord);

    public void delRow(int userId);
}
