package pl.markowski.konrad.bankapp.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/users")
@Log4j2
public class UserController {
    private final UserServiceImplDemo userServiceImplDemo;

    public UserController(UserServiceImplDemo userServiceImplDemo) {
        this.userServiceImplDemo = userServiceImplDemo;
    }

    @PostMapping("/new")
    public String createUser(@RequestBody User user) {
        log.info("create new user");
        userServiceImplDemo.create(user);
        return "redirect:/hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
        log.info("read user with id " + id);
        User user = userServiceImplDemo.read(id);
        UserResponse response = new UserResponse(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public Map<Integer, User> getAllUsers() {
        log.info("read all users");
        return userServiceImplDemo.findAll();
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user) {
        log.info("update user with id" + id);
        userServiceImplDemo.update(id, user);
        return "redirect:/users/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Integer id) {
        log.info("delete user with id" + id);
        userServiceImplDemo.delete(id);
        return "redirect:/users/all";
    }
}
