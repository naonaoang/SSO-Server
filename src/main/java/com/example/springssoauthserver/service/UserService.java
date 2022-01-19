package com.example.springssoauthserver.service;

import com.example.springssoauthserver.dao.UserDAO;
import com.example.springssoauthserver.dao.UserRoleDAO;
import com.example.springssoauthserver.domain.User;
import com.example.springssoauthserver.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRoleDAO userRoleDAO;
    @Autowired
    UserDAO userDAO;

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
}
