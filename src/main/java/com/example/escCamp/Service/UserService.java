package com.example.escCamp.Service;

import com.example.escCamp.Dto.UserDto;
import com.example.escCamp.Entity.User;
import com.example.escCamp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {


    // Repository를 주입받음
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    public void register(UserDto userDto)
    {
        if(userRepository.findByUserId(userDto.getUserId()).isPresent())
        {
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }


        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUserName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);



    }

    public User login(String userId, String password)
    {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if(!passwordEncoder.matches(password, user.getPassword()))
        {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        }

        return user;
    }

}
