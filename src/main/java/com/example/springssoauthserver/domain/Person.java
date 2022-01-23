package com.example.springssoauthserver.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty("ID")
    public int ID;

    @Column(name = "FirstName")
    public String firstName;

    @Column(name = "LastName")
    public String lastName;

    @Column(name = "MiddleName")
    public String middleName;

    @Column(name = "Email")
    public String email;

    @Column(name = "Cellphone")
    public String cellphone;

    @Column(name = "AlternatePhone")
    public String alternatePhone;

    @Column(name = "Gender")
    public String gender;

    @JsonProperty("SSN")
    @Column(name = "SSN")
    public String SSN;

    @JsonProperty("DOB")
    @Column(name = "DOB")
    public String DOB;

    @Column(name = "UserID")
    public int userID;

}