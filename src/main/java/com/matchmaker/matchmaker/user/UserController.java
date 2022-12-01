package com.matchmaker.matchmaker.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public String getUser(/*@PathVariable(name = "id") Long id */) {
        DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getEmail() + "<img alt='user' scr='"+ user.getProfile()+"'></img>";
        //userService.getUserById(id);
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
    public void deleteUser(@PathVariable(name= "id") Long id){
        userService.deleteUserById(id);
    }

    @PatchMapping("/{id}")
    public UserDTO updateUser(@PathVariable(name = "id") Long id, @RequestBody UserRequestDTO updateInformation){
        return userService.updateUserById(id, updateInformation );
    }
}
