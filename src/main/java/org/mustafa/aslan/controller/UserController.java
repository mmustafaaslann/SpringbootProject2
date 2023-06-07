package org.mustafa.aslan.controller;

import org.mustafa.aslan.entity.User;
import org.mustafa.aslan.dto.UserDto;
import org.mustafa.aslan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addANewUser(user);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    /*
    @PutMapping(path = "/{userId}")
    public void updateUser(
            @PathVariable("userId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email

    ){
        userService.updateUser(studentId, name, email);
    }
     */

}
