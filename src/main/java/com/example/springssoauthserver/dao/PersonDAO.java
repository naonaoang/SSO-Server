package com.example.springssoauthserver.dao;

import com.example.springssoauthserver.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class PersonDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public Person findPersonByID(int ID){
        Session session = getCurrentSession();
        Query query = session.createQuery("From Person p WHERE p.id = :ID");
        query.setParameter("ID", ID);
        Person person = (Person) query.getSingleResult();
        return person;
    }

    public Person findPersonByUserID(int ID){
        Session session = getCurrentSession();
        Query query = session.createQuery("From Person p WHERE p.userID = :ID");
        query.setParameter("ID", ID);
        Person person = (Person) query.getSingleResult();
        return person;
    }

    public int createPerson(Person person){
        Session session = getCurrentSession();
        Serializable id = session.save(person);
        System.out.println(id);
        return (int)id;
    }
}
