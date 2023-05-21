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

    // give all the doctors at a particular center(centerId)
    // give the list of all the male doctors at particular center(centerId)
    // give the list of all the female doctors at particular center(centerId)
    // give the list of the all the male doctors who have age above 40
    // give the list of all the center of give center type

}
