package net.oguzkaankaradag.springbootrestfulwebservices.mapper;

import net.oguzkaankaradag.springbootrestfulwebservices.dto.UserDto;
import net.oguzkaankaradag.springbootrestfulwebservices.entity.User;

public class UserMapper {

    //convert User JPA Entity to UserDto
    public static UserDto maptoUserDto(User user) {

        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

        return userDto;
    }

    //convert UserDto to User JPA Entity
    public static User maptoUser(UserDto userDto) {

        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );

        return user;
    }

}
