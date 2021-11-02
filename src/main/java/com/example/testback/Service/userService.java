package com.example.testback.Service;

import com.example.testback.model.dto.ReduplicationDto;
import com.example.testback.model.User;
import org.springframework.transaction.annotation.Transactional;


public interface userService {


    @Transactional
    public User join(User user);

    public String usernameCheck(ReduplicationDto reduplicationDto);
    public String nicknameCheck(ReduplicationDto reduplicationDto);

}
