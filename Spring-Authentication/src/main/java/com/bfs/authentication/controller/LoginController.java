package com.bfs.authentication.controller;

import com.bfs.authentication.domain.User;
import com.bfs.authentication.domain.UserRole;
import com.bfs.authentication.service.UserRoleService;
import com.bfs.authentication.service.UserService;
import com.bfs.authentication.util.CookieUtil;
import com.bfs.authentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";

    private UserService userService;
    private UserRoleService userRoleService;

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService){
        this.userRoleService = userRoleService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/welcome2")
    public String welcome2(HttpServletRequest request, String redirect){
        if (redirect != null || !redirect.equals(" ") ){
            request.getSession().setAttribute("redirect", redirect);
        }
        return "welcome";
    }
    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request, String redirect){
        request.getSession().setAttribute("redirect", "");
        return "welcome";
    }
    @PostMapping("login")
    public String login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                        String username, String password, Model model) {
        List<User> users;
        if (username.contains("@")){
            users = this.userService.getByEmail(username);
        }else{
            users = this.userService.getByUsername(username);
        }
        if (users.isEmpty()){
            model.addAttribute("msg","Wrong username or email");
            return "welcome";
        }
        User currentUser = users.get(0);
        boolean isHr = false;
        if (password.equals(currentUser.getPassword())){
            String token = JwtUtil.generateToken(signingKey, username);
            String userToken = currentUser.getUsername();
            CookieUtil.create(httpServletResponse, jwtTokenCookieName,
                    token, false, -1 , "localhost");
            CookieUtil.createFront(httpServletResponse, "userID",
                    currentUser.getID().toString(), false, -1 , "localhost");
            CookieUtil.createFront(httpServletResponse, "username",
                    currentUser.getUsername(), false, -1 , "localhost");
            List<UserRole> maps = this.userRoleService.getByUserId(currentUser.getID());
            for (UserRole userRole:maps) {
                String role = userRole.getRoles().getDescription();
                if (role.equals("Hiring Manager")){
                    isHr = true;
                    break;
                }
            }
            if (isHr){
                CookieUtil.createFront(httpServletResponse, "role",
                        "hr", false, -1 , "localhost");
                return  "redirect:http://localhost:4200/#/hr/home";
            }else{
                CookieUtil.createFront(httpServletResponse, "role",
                        "user", false, -1 , "localhost");
                return "redirect:onBoard/check";
            }
        }
        model.addAttribute("msg","Wrong password");
        return "welcome";
    }

}
