package springboot.db.replication.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.db.replication.user.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {

        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("master")
    public ResponseEntity<?> getUsersByMaster() {

        return ResponseEntity.ok().body(userService.getUsersByMaster());
    }
}
