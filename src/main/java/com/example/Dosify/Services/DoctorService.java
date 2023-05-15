package com.example.Dosify.Services;

import com.example.Dosify.Dto.RequestDtos.DoctorRequestDto;
import com.example.Dosify.Dto.ResponseDtos.DoctorResponseDto;
import com.example.Dosify.Exception.CenterNotPresentException;

import java.util.List;

public interface DoctorService {
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException;
    public List<DoctorResponseDto> getAllDoctors();
}
