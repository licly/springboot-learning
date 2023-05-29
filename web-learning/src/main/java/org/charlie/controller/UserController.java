package org.charlie.controller;

import jakarta.annotation.Resource;
import jakarta.validation.constraints.Size;
import org.charlie.entity.User;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Charlie-6327
 * @date 2023/5/3
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Resource
    private MessageSource messageSource;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Validated User user) {
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<User> getUser(@Size(min = 5, max = 10) String name) {
        User user = new User();
        user.setName(messageSource.getMessage("name", null, LocaleContextHolder.getLocale()));
        return ResponseEntity.ok(user);
    }
}
