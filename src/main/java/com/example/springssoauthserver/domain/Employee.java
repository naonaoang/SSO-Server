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
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty("ID")
    public int ID;

    @Column(name = "PersonID")
    public int personID;

    @Column(name = "Title")
    public String title;

    @Column(name = "ManagerID")
    public int managerID;

    @Column(name = "StartDate")
    public String startDate;

    @Column(name = "EndDate")
    public String endDate;

    @Column(name = "Avatar")
    public String avatar;

    @Column(name = "Car")
    public String car;

    @Column(name = "visaStatusID")
    public int visaStatusID;

    @Column(name = "visaStartDate")
    public String visaStartDate;

    @Column(name = "visaEndDate")
    public String visaEndDate;

    @Column(name = "driverLicense")
    public String driverLicense;

    @Column(name = "driverLicense_ExpirationDate")
    public String driverLicense_ExpirationDate;
}
