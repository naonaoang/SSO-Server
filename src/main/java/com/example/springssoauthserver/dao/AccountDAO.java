package com.example.springssoauthserver.dao;


import com.example.springssoauthserver.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountDAO {
    private static List<Account> accounts = Arrays.asList(new Account(1,"Jason","123456","Admin"),new Account(2,"Joey","123456","User"));

    public List<Account> findAccountByUserName(String username){
       return accounts.stream().filter(e->e.getUsername().equals(username)).collect(Collectors.toList());
    }
}
