package com.example.escCamp.Controller;

import com.example.escCamp.Dto.UserDto;
import com.example.escCamp.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        userService.register(userDto);
        return ResponseEntity.ok("회원가입 성공");
    }

    //로그아웃
    @PostMapping
    public ResponseEntity<String> logout()
    {
        //로그아웃 처리는 클라이언트에서 상태 삭제로 처리
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }


}
