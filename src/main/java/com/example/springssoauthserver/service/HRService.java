package com.example.springssoauthserver.service;

import com.example.springssoauthserver.dao.RegistrationTokenDAO;
import com.example.springssoauthserver.domain.RegistrationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HRService {
    @Autowired
    RegistrationTokenDAO registrationTokenDAO;

    public RegistrationToken findToken(String token){
        try{
            return registrationTokenDAO.findTokenByToken(token);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
