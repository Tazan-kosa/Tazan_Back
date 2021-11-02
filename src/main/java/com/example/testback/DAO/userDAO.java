package com.example.testback.DAO;

import com.example.testback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDAO extends JpaRepository<User,Long>{
    public User findByEmail(String email);
    public User findByName(String name);
    public User findByNickName(String nickname);
}
