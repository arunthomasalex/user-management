package com.application.usermanagemet.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.application.usermanagemet.domain.Permission;
import com.application.usermanagemet.domain.User;
import com.application.usermanagemet.payload.response.SuccessResponse;
import com.application.usermanagemet.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getPermissions() {
        UsernamePasswordAuthenticationToken auth =  (UsernamePasswordAuthenticationToken) SecurityContextHolder
                .getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName()).get();
        Stream<Permission> permissions = user.getRoles().stream().flatMap(u -> u.getPermissions().stream());
        return ResponseEntity.ok(new SuccessResponse("Completed execution", permissions.map(x -> x.getName()).collect(Collectors.toSet())));
    }
}