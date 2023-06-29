package net.oguzkaankaradag.springbootrestfulwebservices.service;

import net.oguzkaankaradag.springbootrestfulwebservices.dto.UserDto;
import net.oguzkaankaradag.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {


    UserDto createUser(UserDto userDto);

    UserDto getUserBydId(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id , UserDto userdto);

    void deleteUserById(Long id);
}
