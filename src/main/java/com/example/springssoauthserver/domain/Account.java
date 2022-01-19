package com.example.springssoauthserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private String username;
    private String password;
    private String role;
}

