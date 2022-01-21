package com.example.springssoauthserver.dao;

import com.example.springssoauthserver.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<Employee> getAllEmployee(){
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM Employee ");
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    public Employee findEmployeeByID(int ID){
        Session session = getCurrentSession();
        Query query = session.createQuery("From Employee e WHERE e.id = :ID");
        query.setParameter("ID", ID);
        Employee employee = (Employee) query.getSingleResult();
        return employee;
    }

    public Employee findEmployeeByPersonID(int ID){
        Session session = getCurrentSession();
        Query query = session.createQuery("From Employee e WHERE e.personID = :ID");
        query.setParameter("ID", ID);
        Employee employee = (Employee) query.getSingleResult();
        return employee;
    }
}
