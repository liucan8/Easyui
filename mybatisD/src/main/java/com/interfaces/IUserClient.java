package com.interfaces;

import javax.jws.WebService;

/**
 * Created by Administrator on 2016/8/5.
 */
@WebService
public interface IUserClient {
    public String sayHello(String name);
}
