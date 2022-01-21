package com.example.springssoauthserver.controller;

import com.example.springssoauthserver.domain.Person;
import com.example.springssoauthserver.domain.RegistrationToken;
import com.example.springssoauthserver.domain.User;
import com.example.springssoauthserver.service.HRService;
import com.example.springssoauthserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

@Controller
public class RegisterController {
    @Autowired
    HRService hrService;
    @Autowired
    UserService userService;

    @GetMapping({"/auth/register/{token}","/auth/register/"})
    public String regCheck(@PathVariable(required = false) String token) throws ParseException {
        if(token == null){
            return "error";
        }
        else{
            RegistrationToken registrationToken = hrService.findToken(token);
            if (registrationToken == null){
                return "error";
            }
            else{
                Date time1 = Date.from(ZonedDateTime.now().toInstant());
                SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
                Date time2 = formatter.parse(registrationToken.getValidDuration());
                if(time1.compareTo(time2) > 0){
                    return "error";
                }
                else{
                    return "redirect:" + "http://localhost:9999/auth/regUser?email=" + registrationToken.getEmail();
                }
            }
        }
    }

    @GetMapping({"/auth/regUser"})
    public String prepareUser(@RequestParam(name = "email") String email, Model model){
        model.addAttribute("email", email);
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping({"/auth/createUser"})
    public String addUser(@ModelAttribute("user") @Valid User user,
                          @RequestParam(name = "email") String email,
                          HttpServletRequest req, Model model , BindingResult result){
        if (result.hasErrors()) {
            model.addAttribute("email", email);
            return "newUser";
        }
        try {
            int newID = userService.createUser(user);
            return "redirect:" + "http://localhost:9999/auth/regPerson?id="+newID+"&email="+email;
        } catch (Exception e) {
            return e.toString();
        }
    }

    @GetMapping("/auth/regPerson")
    public String preparePerson(Model model, @RequestParam(name = "id") Integer id, @RequestParam(name = "email") String email){
        model.addAttribute("person", new Person());
        model.addAttribute("id", id);
        model.addAttribute("email", email);
        return "newPerson";
    }

    @PostMapping("/auth/createPerson")
    public String addPerson(HttpServletRequest req, Model model, @ModelAttribute("person") @Valid Person person,
                               BindingResult result){
        if (result.hasErrors()) {
            return "newPerson";
        }
        try {
            int newID = userService.createPerson(person);
            System.out.println("success");
            return "success"; //这里应该是redirect到下一步，类似于 return "redirect:" + url of nextpage + "?newID="+ newID
        } catch (Exception e) {
            return e.toString();
        }
    }
}
