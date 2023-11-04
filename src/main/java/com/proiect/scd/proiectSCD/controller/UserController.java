package com.proiect.scd.proiectSCD.controller;

import com.proiect.scd.proiectSCD.entity.User;
import com.proiect.scd.proiectSCD.service.UserService;
import com.proiect.scd.proiectSCD.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ofNullable(userService.findUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (UserValidator.hasUserRole(user)) {
            return ResponseEntity.ofNullable(userService.saveUser(user));
        } else {
            ResponseEntity<String> responseEntity = new ResponseEntity<>("Incorrect role or role missing.", HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deletedSuccessfully = userService.deleteUserById(id);
        if (deletedSuccessfully) {
            return new ResponseEntity<>("Successfully deleted user!", HttpStatus.OK);
        }
        return new ResponseEntity<>("User id not found!", HttpStatus.BAD_REQUEST);
    }
}
