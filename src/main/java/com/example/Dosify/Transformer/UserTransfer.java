package com.example.Dosify.Transformer;

import com.example.Dosify.Dto.RequestDtos.UserRequestDto;
import com.example.Dosify.Dto.ResponseDtos.UserResponseDto;
import com.example.Dosify.Models.User;
import lombok.experimental.UtilityClass;

@UtilityClass// it means if someone tries to create object of this class java will throw an exception
public class UserTransfer {
    public static User userRequestDtoToUser(UserRequestDto userRequestDto){
        return User.builder()
                .name(userRequestDto.getName())
                .age(userRequestDto.getAge())
                .emailId(userRequestDto.getEmailId())
                .mobNo(userRequestDto.getMobNo())
                .isDose1Taken(false)
                .isDose2Taken(false)
                .gender(userRequestDto.getGender())
                .build();
    }
    public static UserResponseDto UserToUserResponseDto(User user){
        return  UserResponseDto.builder()
                .name(user.getName())
                .age(user.getAge())
                .emailId(user.getEmailId())
                .mobNo(user.getMobNo())
                .build();
    }
}
