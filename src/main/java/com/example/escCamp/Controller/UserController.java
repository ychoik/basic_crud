package com.example.escCamp.Controller;

import com.example.escCamp.Dto.LoginDto;
import com.example.escCamp.Dto.UserDto;
import com.example.escCamp.Entity.User;
import com.example.escCamp.Service.UserService;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            User user = userService.login(loginDto.getUserId(), loginDto.getPassword());

            // 로그인 성공 시 원하는 데이터를 응답 (예: 토큰, 사용자 정보 등)
            return ResponseEntity.ok(user);

        } catch (IllegalArgumentException e) {
            // 아이디 또는 비밀번호 오류
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());

        } catch (Exception e) {
            // 기타 예외
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("서버 오류가 발생했습니다.");
        }
    }


    //로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout()
    {
        //로그아웃 처리는 클라이언트에서 상태 삭제로 처리
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }


}
