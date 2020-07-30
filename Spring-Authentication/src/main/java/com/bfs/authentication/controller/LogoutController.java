package com.bfs.authentication.controller;

import com.bfs.authentication.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {

    @GetMapping("logout")
    public String identification(HttpServletResponse httpServletResponse){
        CookieUtil.clear(httpServletResponse, "JWT-TOKEN");
        CookieUtil.clear(httpServletResponse, "userID");
        CookieUtil.clear(httpServletResponse, "role");
        return "redirect:http://localhost:8082/welcome";
    }

}
