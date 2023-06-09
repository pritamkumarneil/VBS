package com.example.Dosify.Controllers;

import com.example.Dosify.Dto.RequestDtos.DoctorRequestDto;
import com.example.Dosify.Dto.ResponseDtos.DoctorResponseDto;
import com.example.Dosify.Exception.CenterNotPresentException;
import com.example.Dosify.Repository.DoctorRepository;
import com.example.Dosify.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto){

        try {
            DoctorResponseDto doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
            doctorResponseDto.setMessage("This Doctor Added Successfully");
            return new ResponseEntity<>(doctorResponseDto, HttpStatus.CREATED);

        } catch (CenterNotPresentException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get-all")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors(){
        List<DoctorResponseDto> doctorResponseDtos=doctorService.getAllDoctors();
        return  new ResponseEntity<>(doctorResponseDtos,HttpStatus.ACCEPTED);
    }
    //get all the doctors who have more than 10 appointments
    // get all the doctors who's age is above 40
    // get the ration of male to female doctors
    // update the details of the doctor based on email of the doctor
}
