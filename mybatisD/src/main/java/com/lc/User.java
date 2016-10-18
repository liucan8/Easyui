package com.lc;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/29.
 */

public class User {
    private int user_id;
    private String user_name;
    private String user_passWord;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date create_time;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_passWord() {
        return user_passWord;
    }

    public void setUser_passWord(String user_passWord) {
        this.user_passWord = user_passWord;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
