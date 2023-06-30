package net.oguzkaankaradag.springbootrestfulwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.oguzkaankaradag.springbootrestfulwebservices.dto.UserDto;
import net.oguzkaankaradag.springbootrestfulwebservices.entity.User;
import net.oguzkaankaradag.springbootrestfulwebservices.exception.EmailAlreadyExistsException;
import net.oguzkaankaradag.springbootrestfulwebservices.exception.ResourceNotFoundException;
import net.oguzkaankaradag.springbootrestfulwebservices.mapper.UserMapper;
import net.oguzkaankaradag.springbootrestfulwebservices.repository.UserRepository;
import net.oguzkaankaradag.springbootrestfulwebservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        //convert userDTO to User by UserMapper class
        //User user = UserMapper.maptoUser(userDto);

        User user = modelMapper.map(userDto, User.class);

        Optional<User> optionalUser =  userRepository.findByEmail(user.getEmail());

        if (optionalUser.isPresent())
            throw new EmailAlreadyExistsException("Email already exists for user");


        User savedUser = userRepository.save(user);

        //convert saved user entity to dto

        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        return savedUserDto;
    }

    @Override
    public UserDto getUserBydId(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User" , "id" , id));

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
               .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userdto) {
        User existingUser = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User" , "id" ,id )
        );
        existingUser.setFirstName(userdto.getFirstName());
        existingUser.setLastName(userdto.getLastName());
        existingUser.setEmail(userdto.getEmail());
        User updatedUser = userRepository.save(existingUser);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
