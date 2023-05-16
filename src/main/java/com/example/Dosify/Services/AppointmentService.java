package com.example.Dosify.Services;

import com.example.Dosify.Dto.RequestDtos.AppointmentRequestDto;
import com.example.Dosify.Dto.ResponseDtos.AppointmentResponseDto;
import com.example.Dosify.Exception.DoctorNotFoundException;
import com.example.Dosify.Exception.UserNotFoundException;

public interface AppointmentService {
    public AppointmentResponseDto addAppointment(AppointmentRequestDto appointmentRequestDto) throws Exception;
}
