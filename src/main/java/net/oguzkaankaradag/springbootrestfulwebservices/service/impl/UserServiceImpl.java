package net.oguzkaankaradag.springbootrestfulwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.oguzkaankaradag.springbootrestfulwebservices.dto.UserDto;
import net.oguzkaankaradag.springbootrestfulwebservices.entity.User;
import net.oguzkaankaradag.springbootrestfulwebservices.mapper.UserMapper;
import net.oguzkaankaradag.springbootrestfulwebservices.repository.UserRepository;
import net.oguzkaankaradag.springbootrestfulwebservices.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        //convert userDTO to User by UserMapper class
        User user = UserMapper.maptoUser(userDto);

        User savedUser = userRepository.save(user);

        //convert saved user entity to dto

        return UserMapper.maptoUserDto(savedUser);
    }

    @Override
    public UserDto getUserBydId(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();

        return UserMapper.maptoUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::maptoUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userdto) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setFirstName(userdto.getFirstName());
        existingUser.setLastName(userdto.getLastName());
        existingUser.setEmail(userdto.getEmail());
        User updatedUser = userRepository.save(existingUser);

        return UserMapper.maptoUserDto(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
