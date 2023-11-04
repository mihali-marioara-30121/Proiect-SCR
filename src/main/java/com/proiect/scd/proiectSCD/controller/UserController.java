package com.proiect.scd.proiectSCD.controller;

import com.proiect.scd.proiectSCD.dtos.LoginRequest;
import com.proiect.scd.proiectSCD.dtos.UserDTO;
import com.proiect.scd.proiectSCD.entity.User;
import com.proiect.scd.proiectSCD.service.UserService;
import com.proiect.scd.proiectSCD.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Implement user login logic and perform authentication
        // You can use Spring Security with HTTP Basic Authentication
        // Return the response based on the authentication result

        // Check the username and password (you can validate them against your database)
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Perform your authentication logic here (e.g., validate against a database)
        if (credentialsMatch(username, password)) {
            // If authentication is successful, create an Authentication object
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);

            // Set the Authentication object in the SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Return a success response with a message or status code
            return ResponseEntity.ok("Login successful");
        } else {
            // Return an unauthorized response (HTTP 401) for failed authentication
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    private boolean credentialsMatch(String username, String password) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User user = userService.findUserByUsername(username);
            return user != null && passwordEncoder.matches(password, user.getPassword());
    }

    //REGISTERING - not enabled at the moment

//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        User user = userService.mapDTOtoUser(userDTO);
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//
//        return ResponseEntity.ofNullable(userService.saveUser(user));
//    }

    /*
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

     */
}
