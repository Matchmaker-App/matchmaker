package com.matchmaker.matchmaker.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("")
    public List<UserDTO> getUsers(){
        return userService.getAllUser();
    }

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserRequestDTO user){
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name= "id") Long id){
        userService.deleteUserById(id);
    }

    @PatchMapping("/{id}")
    public UserDTO updateUser(@PathVariable(name = "id") Long id, @RequestBody UserRequestDTO updateInformation){
        return userService.updateUserById(id, updateInformation );
    }
}
