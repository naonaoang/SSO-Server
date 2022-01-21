package com.example.springssoauthserver.controller;

import com.example.springssoauthserver.constant.JwtConstant;
import com.example.springssoauthserver.domain.User;
import com.example.springssoauthserver.domain.UserRole;
import com.example.springssoauthserver.security.CookieUtil;
import com.example.springssoauthserver.security.JwtUtil;
import com.example.springssoauthserver.service.ProfileService;
import com.example.springssoauthserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    ProfileService profileService;

    @GetMapping("/auth/login")
    public String login() {
        return "login";
    }

    @PostMapping("/auth/login")
    public String login(@RequestParam(value = "redirect", required = false) String redirect, HttpServletResponse res,
                        @RequestParam String username,@RequestParam String password,@RequestParam(name = "asHR", required = false) String asHR,
                        Model model) {
        User user = userService.findUserByUsername(username);
        if (username==null || password==null || user == null || !password.equals(user.getPassword())) {
            model.addAttribute("credentialError", "Invalid username or password");
            return "login";
        }
        String role = "Employee";
        UserRole userRole = userService.findUserRoleByID(user.getID());
        if(asHR == null){
        }
        else {
            if (asHR.equals("true")) {
                if (userRole.getRole().getRoleName().equals("HR")) {
                    role = "HR";
                } else {
                    model.addAttribute("credentialError", "Invalid role");
                    return "login";
                }
            }
        }
        int id = profileService.findEmployeebyUserID(user.getID()).getID();
        String jwt = JwtUtil.generateToken(username, JwtConstant.JWT_VALID_DURATION,role,userRole.getID());
        //Setting maxAge to -1 will preserve it until the browser is closed.
        CookieUtil.create(res, JwtConstant.JWT_COOKIE_NAME, jwt, false, -1, "localhost");
        System.out.println(role);
        if(redirect == null || redirect.equals("")){
//            redirect = "http://localhost:8080/hr/employee-profile";
            if(role.toLowerCase().equals("hr")){
                redirect = "http://localhost:4200/hr/"+id;
            }
            else{
                redirect = "http://localhost:4200/user/"+id;
            }
        }

        return "redirect:" + redirect;
    }


    @GetMapping("/logout")
    public String logout(HttpServletResponse res, @RequestParam(value = "redirect",required = false) String redirect) {
        if(redirect == null)
            redirect = "http://localhost:9999/auth/login";
        CookieUtil.clear(res, JwtConstant.JWT_COOKIE_NAME, "localhost");
        return "redirect:" + redirect;
    }
}
