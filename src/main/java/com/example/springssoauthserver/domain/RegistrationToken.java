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
@Table(name = "RegistrationToken")
public class RegistrationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty("ID")
    public int ID;

    @Column(name = "token")
    public String token;

    @Column(name = "validDuration")
    public String validDuration;

    @Column(name = "email")
    public String email;
}
