package com.example.springssoauthserver.dao;

import com.example.springssoauthserver.domain.User;
import com.example.springssoauthserver.domain.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class UserDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public User findUserByUsername(String username){
        Session session = getCurrentSession();
        Query query = session.createQuery("From User u WHERE u.username = :username");
        query.setParameter("username", username);
        User user = (User) query.getSingleResult();
        return user;
    }

    public int createUser(User user){
        Session session = getCurrentSession();
        Serializable id = session.save(user);
        System.out.println(id);
        return (int)id;
    }
}
