package com.example.Dosify.Controllers;

import com.example.Dosify.Dto.RequestDtos.AppointmentRequestDto;
import com.example.Dosify.Dto.ResponseDtos.AppointmentResponseDto;
import com.example.Dosify.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @PostMapping("book-appointment")
    public ResponseEntity<AppointmentResponseDto> bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) throws Exception {
        AppointmentResponseDto appointmentResponseDto=appointmentService.addAppointment(appointmentRequestDto);
        return new ResponseEntity<>(appointmentResponseDto, HttpStatus.CREATED);
    }

}
