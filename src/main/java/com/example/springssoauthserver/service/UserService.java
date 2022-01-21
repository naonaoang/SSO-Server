package com.example.springssoauthserver.service;

import com.example.springssoauthserver.dao.PersonDAO;
import com.example.springssoauthserver.dao.UserDAO;
import com.example.springssoauthserver.dao.UserRoleDAO;
import com.example.springssoauthserver.domain.Person;
import com.example.springssoauthserver.domain.User;
import com.example.springssoauthserver.domain.UserRole;
import com.example.springssoauthserver.domain.UserRoleDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    @Autowired
    UserRoleDAO userRoleDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    PersonDAO personDAO;

    public User findUserByUsername(String username){
        try{
            return userDAO.findUserByUsername(username);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public UserRole findUserRoleByID(int ID){
        try{
            return userRoleDAO.findUserRoleByID(ID);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public int createUser(User user){
        try{
            int id = userDAO.createUser(user);
            UserRoleDomain userRoleDomain = new UserRoleDomain();
            userRoleDomain.setUserID(id);
            userRoleDomain.setRoleID(2);
            userRoleDomain.setActiveFlag(true);
            userRoleDomain.setCreateDate(LocalDate.now().toString());
            return userRoleDAO.createUserRole(userRoleDomain);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return -1;
    }

    public int createPerson(Person person){
        try{
            return personDAO.createPerson(person);
        }catch (Exception e){
            System.out.println(e);
        }
        return -1;
    }
}
