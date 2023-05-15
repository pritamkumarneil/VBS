package com.example.Dosify.Services.ServiceImpl;

import com.example.Dosify.Dto.RequestDtos.UserRequestDto;
import com.example.Dosify.Dto.ResponseDtos.UserResponseDto;
import com.example.Dosify.Models.User;
import com.example.Dosify.Repository.UserRepository;
import com.example.Dosify.Services.UserService;
import com.example.Dosify.Transformer.UserTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user= UserTransfer.userRequestDtoToUser(userRequestDto);
        User savedUser=userRepository.save(user);
        return UserTransfer.UserToUserResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<UserResponseDto> ans=new ArrayList<>();
        List<User> users=userRepository.findAll();
        for(User user: users){
            UserResponseDto userResponseDto=UserTransfer.UserToUserResponseDto(user);
            ans.add(userResponseDto);
        }
        return ans;
    }

    @Override
    public UserResponseDto getUserByEmailId(String emailId) {
        User user=userRepository.findByEmailId(emailId);
        return UserTransfer.UserToUserResponseDto(user);
    }

    @Override
    public UserResponseDto updateUserByMobNo(String mobNo,String name) {
        User user=userRepository.findByMobNo(mobNo);
        String oldName="";
       try {
            oldName=user.getName();
        }
       catch (Exception e){
           UserResponseDto userResponseDto =new UserResponseDto();
           userResponseDto.setMessage("Invalid Phone Number");
           return userResponseDto;
       }
        user.setName(name);
        userRepository.save(user);
        UserResponseDto userResponseDto=UserTransfer.UserToUserResponseDto(user);
        userResponseDto.setMessage(oldName+" changed to "+name);
        return userResponseDto;


    }

    @Override
    public List<UserResponseDto> getUsersWithNoVaccination() {
        List<User> users=userRepository.findByIsDose1Taken(false);
        List<UserResponseDto> userResponseDtos=new ArrayList<>();
        for(User user: users){
            userResponseDtos.add(UserTransfer.UserToUserResponseDto(user));
        }
        return userResponseDtos;
    }
}
