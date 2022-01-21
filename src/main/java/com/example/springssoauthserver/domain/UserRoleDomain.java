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
@Table(name = "userrole")
public class UserRoleDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty("ID")
    public int ID;

    @Column(name = "userID")
    public int userID;

    @Column(name = "roleID")
    public int roleID;

    @Column(name = "activeFlag")
    public boolean activeFlag;

    @Column(name = "createDate")
    public String createDate;
}
