package com.example.springssoauthserver.dao;

import com.example.springssoauthserver.domain.User;
import com.example.springssoauthserver.domain.UserRole;
import com.example.springssoauthserver.domain.UserRoleDomain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class UserRoleDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public UserRole findUserRoleByID(int ID){
        Session session = getCurrentSession();
        Query query = session.createQuery("From UserRole u WHERE u.userID = :ID");
        query.setParameter("ID", ID);
        UserRole userRole = (UserRole) query.getSingleResult();
        return userRole;
    }

    public int createUserRole(UserRoleDomain userRoleDomain){
        Session session = getCurrentSession();
        Serializable id = session.save(userRoleDomain);
        System.out.println(id);
        return (int)id;
    }
}
