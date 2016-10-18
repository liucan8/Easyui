package com.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/1.
 */
public class User implements Serializable{
    private static final long serialVersionUID = -7844814161214705705L;
    @NotEmpty(message = "the name cannot be empty.")
    private String name;
    @NotEmpty(message = "the address cannot be empty.")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String toString(){
       return "User--name:"+name+"address:"+address;
    }
}
