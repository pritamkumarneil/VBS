package com.example.Dosify.Services;

import com.example.Dosify.Dto.RequestDtos.UserRequestDto;
import com.example.Dosify.Dto.ResponseDtos.UserResponseDto;
import com.example.Dosify.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public UserResponseDto addUser(UserRequestDto userRequestDto);

    public List<UserResponseDto> getAllUser();
    public UserResponseDto getUserByEmailId(String emailId);
    public UserResponseDto updateUserByMobNo(String mobNo,String name);
    public List<UserResponseDto> getUsersWithNoVaccination();
}
