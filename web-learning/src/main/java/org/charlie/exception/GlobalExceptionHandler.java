package org.charlie.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Charlie-6327
 * @date 2023/5/2
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // @ExceptionHandler(value = Exception.class)
    // @ResponseBody
    // public ResponseEntity<?> handleException(HttpServletRequest request, Exception e) {
    //     log.error("exception", e);
    //     return new ResponseEntity<>("global exception", HttpStatus.OK);
    // }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder("参数校验失败：");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
