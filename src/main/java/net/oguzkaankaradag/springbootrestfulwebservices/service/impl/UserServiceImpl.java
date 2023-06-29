package net.oguzkaankaradag.springbootrestfulwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.oguzkaankaradag.springbootrestfulwebservices.entity.User;
import net.oguzkaankaradag.springbootrestfulwebservices.repository.UserRepository;
import net.oguzkaankaradag.springbootrestfulwebservices.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
         return userRepository.save(user);
    }

    @Override
    public User getUserBydId(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
