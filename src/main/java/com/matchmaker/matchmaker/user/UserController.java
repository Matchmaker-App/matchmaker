package com.matchmaker.matchmaker.user;

import com.matchmaker.matchmaker.exception.ResourceNotFoundException;
import com.matchmaker.matchmaker.security.User;
import com.matchmaker.matchmaker.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public com.matchmaker.matchmaker.user.User getCurrentUser(@User UserPrincipal userPrincipal){
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable(name = "id") String id) {
        return userService.getUserById(Long.valueOf(id));
    }

    @GetMapping("")
    public List<UserDTO> getUsers(){
        return userService.getAllUser();
    }

    @PostMapping("")
    public UserDTO createUser(@RequestBody UserRequestDTO user){
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name= "id") String id){
        userService.deleteUserById(Long.valueOf(id));
    }

    @PatchMapping("/{id}")
    public UserDTO updateUser(@PathVariable(name = "id") String id, @RequestBody UserRequestDTO updateInformation){
        return userService.updateUserById(Long.valueOf(id), updateInformation );
    }
}
