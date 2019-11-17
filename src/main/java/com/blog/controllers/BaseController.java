package com.blog.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

public class BaseController {

    private static String USER = "luffy";
    private static String PASSWORD = "pirateking";

    public boolean isValidUser(HttpHeaders headers){
        String user = null;
        String password = null;
        if(headers != null && headers.get("X-USER") != null){
            user = headers.get("X-USER").get(0);
        }
        if(headers != null && headers.get("X-PASSWORD") != null){
            password = headers.get("X-PASSWORD").get(0);
        }
        if(StringUtils.isEmpty(user) || StringUtils.isEmpty(password)){
            return false;
        }
        if(USER.equals(user) && password.equals(PASSWORD)){
            return true;
        }
        return false;
    }
}
