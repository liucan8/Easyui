package com.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/18.
 */
public class ParamUtil {
    public static Map<String,String> formatError(BindingResult result){
        Map<String,String> map = new HashMap<String, String>();
        List<FieldError> errList = result.getFieldErrors();
        int k = 1;
        for(FieldError err:errList){
            map.put("err"+k++,err.getDefaultMessage());
        }
        return map;
    }
}
