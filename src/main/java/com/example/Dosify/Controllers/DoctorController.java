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
        DoctorResponseDto doctorResponseDto= null;
        try {
            doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
        } catch (CenterNotPresentException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        doctorResponseDto.setMessage("This Doctor Added Successfully");
        return new ResponseEntity<>(doctorResponseDto, HttpStatus.CREATED);
    }
    @GetMapping("get-all")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors(){
        List<DoctorResponseDto> doctorResponseDtos=doctorService.getAllDoctors();
        return  new ResponseEntity<>(doctorResponseDtos,HttpStatus.ACCEPTED);
    }
}
