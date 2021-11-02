package com.example.testback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TourUser")
public class User {

    @Id//primarykey 등록
    @GeneratedValue(strategy = GenerationType.IDENTITY)//연결된 DB의 너버링 전략을 따라간다는 설정
    @Column(name = "UserId")
    private Long userId;//auto_increment

    @Column(nullable = false,length = 20,unique = true,name = "NickName")//닉네임
    private String nickName;

    @Column(nullable = false,length = 15,name = "PhoneNumber")//닉네임
    private String phoneNumber;

    @Column(nullable = false,length = 30,unique = true,name = "Email")//닉네임
    private String email;
    @Column(nullable = false,length = 100,name = "PassWord")//hash 암호화시를 위해 넉넉하게 설정
    private String passWord;

    @Enumerated(EnumType.STRING)//DB에는 RoleType이라는 Enum이 없으므로 적용해줌
    @Column(name = "Auth", length=45)
    private Role auth;	//USER,ADMIN,MANAGE으로 강제

    @Column(nullable = false,length = 45,name = "Name")
    private String name;

}


