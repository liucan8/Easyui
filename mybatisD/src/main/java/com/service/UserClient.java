package com.service;

import com.interfaces.IUserClient;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * Created by Administrator on 2016/8/5.
 */
@WebService(endpointInterface = "com.interfaces.IUserClient")
public class UserClient implements IUserClient {
    public String sayHello(String name){
        return "hello "+name;
    }
}
