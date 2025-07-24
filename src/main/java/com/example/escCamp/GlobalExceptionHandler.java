package com.example.escCamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 404 에러 처리 (요청한 URL을 찾지 못함)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> handleNotFound(NoHandlerFoundException e) {
        return new ResponseEntity<>("요청하신 부분을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
    }

    // IllegalArgumentException 처리 예시
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        return new ResponseEntity<>("잘못된 요청입니다: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // 나머지 모든 에러 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAll(Exception e) {
        return new ResponseEntity<>("서버에 오류가 발생했습니다. 다시 시도해주세요.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
