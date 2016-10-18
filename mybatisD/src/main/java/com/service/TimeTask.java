package com.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/8/17.
 */
@Component
public class TimeTask {
    @Scheduled(fixedRate = 2000)
    public void feek(){
       // System.out.println("LCLC>>this is task...");
    }
}
