package com.example.escCamp.Repository;

import com.example.escCamp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long>{
    //userId로 유저 찾기
    Optional<User> findByUserId(String userId);






}



