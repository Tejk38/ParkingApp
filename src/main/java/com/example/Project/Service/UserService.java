package com.example.Project.Service;

import com.example.Project.Dto.UserDto;
import com.example.Project.Entity.User;

import java.util.List;

public interface UserService {


    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();


}
