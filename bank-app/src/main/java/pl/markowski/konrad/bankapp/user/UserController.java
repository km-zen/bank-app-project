package pl.markowski.konrad.bankapp.user;

import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<CreatedUserResponseDto> createUser(@RequestBody @Valid CreatedUserRequestDto request ) {
        User user = UserMapper.mapFromCreatedUserRequestDtoToUser(request);
        log.info("create new user");
        userServiceImplDemo.create(user);
        CreatedUserResponseDto response = UserMapper.mapFromUserToCreatedUserResponseDto(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponseDto> getUserById(@PathVariable Integer id) {
        log.info("read user with id " + id);
        User user = userServiceImplDemo.read(id);
        GetUserResponseDto response = UserMapper.mapFromUserToGetUserResponseDto(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetAllUsersResponseDto> getAllUsers() {
        Map<Integer,User> allUsers = userServiceImplDemo.findAll();
        log.info("read all users");
        GetAllUsersResponseDto response = UserMapper.mapFromAllUsersToGetAllUsersResponseDto(allUsers);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponseDto>updateUser(@PathVariable Integer id, @RequestBody @Valid UpdateUserRequestDto request) {
        User user = UserMapper.mapFromUpdateUserRequestDtoToUser(request);
        userServiceImplDemo.update(id, user);
        log.info("update user with id" + id);
        UpdateUserResponseDto response = UserMapper.mapFromUserToUpdatedUserResponseDto(user);
        return ResponseEntity.ok(response);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<DeleteUserResponseDto> deleteUserById(@PathVariable Integer id) {
        log.info("delete user with id" + id);
        userServiceImplDemo.delete(id);
        DeleteUserResponseDto response = UserMapper.mapFromUserToDeleteUserResponseDto(id);
        return ResponseEntity.ok(response);
    }
}
