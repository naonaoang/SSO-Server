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
@Table(name = "UserRole")
public class UserRole {
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

    @Column(name = "status")
    public String status;

    @OneToOne
    @JoinColumn(name = "UserID")
    public User user;

    @OneToOne
    @JoinColumn(name = "RoleID")
    public Role role;
}
