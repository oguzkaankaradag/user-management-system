package net.oguzkaankaradag.springbootrestfulwebservices.controller;

import lombok.AllArgsConstructor;
import net.oguzkaankaradag.springbootrestfulwebservices.dto.UserDto;
import net.oguzkaankaradag.springbootrestfulwebservices.entity.User;
import net.oguzkaankaradag.springbootrestfulwebservices.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;


    //build create user REST API
    //http://localhost:8080/api/users
    @PostMapping //
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    //build get user by id REST API
    //http://localhost:8080/api/users/{id}
    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById( @PathVariable("id") Long userId){
        UserDto userdto = userService.getUserBydId(userId);
        return new ResponseEntity<>(userdto,HttpStatus.OK);
    }


    //build get  all users REST API
    //http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos = userService.getAllUsers();
        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }


    //build update user  REST API
    //http://localhost:8080/api/users/{id}
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")       //we can simply think put body that in web request at given id in path
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId , @RequestBody UserDto userDto){
        UserDto updatedUserDto = userService.updateUser(userId,userDto);
        return new ResponseEntity<>(updatedUserDto,HttpStatus.OK);
    }

    //build delete user by id   REST API
    //http://localhost:8080/api/users/{id}
    //http://localhost:8080/api/users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
        return new ResponseEntity<>("User Deleted Successfully !!", HttpStatus.OK);
    }
}
