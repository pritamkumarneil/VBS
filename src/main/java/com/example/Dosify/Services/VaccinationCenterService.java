package com.example.Dosify.Services;

import com.example.Dosify.Dto.RequestDtos.CenterRequestDto;
import com.example.Dosify.Dto.ResponseDtos.CenterResponseDto;

public interface VaccinationCenterService {
    CenterResponseDto addVaccinationCenter(CenterRequestDto centerRequestDto);
}
