package ir.javapro.session3.controller;

import ir.javapro.session3.dto.request.UserRequest;
import ir.javapro.session3.dto.respond.UserRespond;
import ir.javapro.session3.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserRespond> save(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.save(userRequest));
    }
}
