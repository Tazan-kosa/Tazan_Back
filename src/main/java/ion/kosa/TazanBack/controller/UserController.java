package ion.kosa.TazanBack.controller;


import ion.kosa.TazanBack.Service.userServiceImpl;
import ion.kosa.TazanBack.VO.loginVO;
import ion.kosa.TazanBack.VO.userVO;
import ion.kosa.TazanBack.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

        return new ResponseEntity<>(userService.join(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/admin/user/userList")
    private List<userVO> usermanageList(){
        return userService.usermanageList();
    }

    @DeleteMapping("/api/admin/user/deleteUser/{userID}")
    public void reviewDelete(@PathVariable Long userID) {
        userService.userdelete(userID);
    }

    @GetMapping("/api/admin/user/getUser/{userID}")
    private userVO userfindID(@PathVariable Long userID){
        return userService.userfindID(userID);
    }
}
