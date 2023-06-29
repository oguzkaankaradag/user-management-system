package net.oguzkaankaradag.springbootrestfulwebservices.service;

import net.oguzkaankaradag.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserBydId(Long id);

    List<User> getAllUsers();

    User updateUser(Long id , User user);

    void deleteUserById(Long id);
}
