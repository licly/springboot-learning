package org.charlie.controller;

import org.charlie.entity.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Charlie-6327
 * @date 2023/5/1
 */
@RestController
public class ResponseBodyController {

    @GetMapping(value = "/user/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getJsonUser() {
        return ResponseEntity.ok(new User().setId(1L).setName("charlie").setAddress("beijing"));
    }

    @GetMapping(value = "/user/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<User> getXmlUser() {
        return ResponseEntity.ok(new User().setId(1L).setName("charlie").setAddress("beijing"));
    }
}
