package com.galaxy.microservice.oauth2.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName： UserManagementController
 * @Description
 * @Author alan qin
 * @Date 2019-05-29
 **/

@RestController
@RefreshScope
public class UserManagementController {
    /**
     * redis sesion共享
     * @param request
     * @return
     */
    @GetMapping("/getUser")
    public String getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if(StringUtils.isEmpty(username)){
            session.setAttribute("username", "testSessionRedis|" + System.currentTimeMillis());
        }
        return username;
    }

}
