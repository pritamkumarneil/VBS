package com.example.Dosify.Controllers;

import com.example.Dosify.Dto.RequestDtos.CenterRequestDto;
import com.example.Dosify.Dto.ResponseDtos.CenterResponseDto;
import com.example.Dosify.Services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vaccination-center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;
    @PostMapping("add-center")
    public ResponseEntity addVaccinationCenter(@RequestBody CenterRequestDto centerRequestDto){
        CenterResponseDto centerResponseDto=vaccinationCenterService.addVaccinationCenter(centerRequestDto);
        return new ResponseEntity(centerResponseDto, HttpStatus.CREATED);
    }
}
