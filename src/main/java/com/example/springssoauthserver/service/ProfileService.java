package com.example.springssoauthserver.service;

import com.example.springssoauthserver.dao.EmployeeDAO;
import com.example.springssoauthserver.dao.PersonDAO;
import com.example.springssoauthserver.domain.Employee;
import com.example.springssoauthserver.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfileService {
    @Autowired
    EmployeeDAO employeeDAO;
    @Autowired
    PersonDAO personDAO;

    public List<Employee> getAllEmployee(){
        try {
            return employeeDAO.getAllEmployee();
        }catch (Exception E){
            System.out.println(E);
        }
        return null;
    }

    public Employee findEmployeeByID(int ID){
        try {
            return employeeDAO.findEmployeeByID(ID);
        }
        catch (Exception E){
            System.out.println(E);
        }
        return null;
    }

    public Employee findEmployeeByPersonID(int ID){
        try {
            return employeeDAO.findEmployeeByPersonID(ID);
        }
        catch (Exception E){
            System.out.println(E);
        }
        return null;
    }

    public Person findPersonByID(int ID){
        try {
            return personDAO.findPersonByID(ID);
        }
        catch (Exception E){
            System.out.println(E);
        }
        return null;
    }

    public Person findPersonByUserID(int ID){
        try {
            return personDAO.findPersonByUserID(ID);
        }
        catch (Exception E){
            System.out.println(E);
        }
        return null;
    }

    public Employee findEmployeebyUserID(int ID){
        try {
            return employeeDAO.findEmployeeByPersonID(personDAO.findPersonByUserID(ID).getID());
        }
        catch (Exception E){
            System.out.println(E);
        }
        return null;
    }
}
