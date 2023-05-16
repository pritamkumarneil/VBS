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
    @GetMapping("users-with-dose1-only")
    public ResponseEntity<List<UserResponseDto>> getAllUserWithDose1Only(){
        List<UserResponseDto> userResponseDtos=userService.getAllUserWithDose1Only();
        return new ResponseEntity<>(userResponseDtos,HttpStatus.FOUND);
    }
    // All users who are fully vaccinated;
    @GetMapping("get-fully-vaccinated-users")
    public ResponseEntity<List<UserResponseDto>> getAllFullyVaccinatedUsers(){
        List<UserResponseDto> userResponseDtos=userService.getAllFullyVaccinatedUsers();
        return new ResponseEntity<>(userResponseDtos,HttpStatus.ACCEPTED);
    }
    // all male users who  have not taken even a single dose;
    @GetMapping("all-male-with-no-vaccine")
    public ResponseEntity<List<UserResponseDto>> getAllMaleWithNoVaccination(){
        List<UserResponseDto> userResponseDtos=userService.getAllMaleWithNoVaccination();
        return new ResponseEntity<>(userResponseDtos,HttpStatus.ACCEPTED);
    }
    // all female user who are fully vaccinated;
    @GetMapping("all-female-fully-vaccinated")
    public ResponseEntity<List<UserResponseDto>> getAllFemaleFullyVaccinated(){
        List<UserResponseDto> userResponseDtos=userService.getAllFemaleFullyVaccinated();
        return new ResponseEntity<>(userResponseDtos,HttpStatus.ACCEPTED);
    }

}
