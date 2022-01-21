package com.example.springssoauthserver.dao;

import com.example.springssoauthserver.domain.RegistrationToken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class RegistrationTokenDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public RegistrationToken findTokenByToken(String token){
        Session session = getCurrentSession();
        Query query = session.createQuery("From RegistrationToken t WHERE t.token = :token");
        query.setParameter("token", token);
        RegistrationToken registrationToken = (RegistrationToken) query.getSingleResult();
        return registrationToken;
    }


}
