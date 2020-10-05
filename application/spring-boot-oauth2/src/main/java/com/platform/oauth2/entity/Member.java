package com.platform.oauth2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "member_id")
    private Long id;

    private String password;

    private String name;

    private String phone;

    public void update(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
