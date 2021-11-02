package com.example.testback.controller;


import com.example.testback.Service.userServiceImpl;
import com.example.testback.VO.loginVO;
import com.example.testback.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final userServiceImpl userService;

    //로그인
    @PostMapping("/userLogin")
    public String login(@RequestBody loginVO loginVO){
        return "재혁";
    }

    @PostMapping("/userJoin")
    private ResponseEntity<?> join(@RequestBody User user){
        System.out.println(user.getPassWord());
        System.out.println(user.getName());

        return new ResponseEntity<>(userService.join(user), HttpStatus.CREATED);
    }
}
