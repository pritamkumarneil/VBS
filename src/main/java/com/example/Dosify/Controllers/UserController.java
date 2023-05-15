package com.example.Dosify.Controllers;

import com.example.Dosify.Dto.RequestDtos.UserRequestDto;
import com.example.Dosify.Dto.ResponseDtos.UserResponseDto;
import com.example.Dosify.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("add")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto=userService.addUser(userRequestDto);
        userResponseDto.setMessage("This user Added Successfully");
        return new ResponseEntity<>(userResponseDto,HttpStatus.CREATED);
    }
    @GetMapping("get-all")
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        List<UserResponseDto> userResponseDtos=userService.getAllUser();
        return  new ResponseEntity<>(userResponseDtos,HttpStatus.CREATED);
    }

    // find by emailId;
    @GetMapping("get-by-emailId")
    public UserResponseDto getUserByEmailId(@RequestParam("emailId")String emailId){
        return userService.getUserByEmailId(emailId);
    }
    // update the name of the user (given mobile no)
    @PutMapping("update-name-by-mobNo")
    public UserResponseDto updateUserByMobNo(@RequestParam("name")String name,@RequestParam("mobNo")String mobNo){
        return userService.updateUserByMobNo(mobNo,name);
    }
    // all the user who have not taken even a single dose
    @GetMapping("user-without-vaccine")
    public List<UserResponseDto> getAllUserWithNoVaccination(){
        return userService.getUsersWithNoVaccination();
    }
    // all user who have taken dose1 but not dose2

    // All users who are fully vaccinated;
    // all male users who  have not taken even a single dose;
    // all female user who are fully vaccinated;
}
