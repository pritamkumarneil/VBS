package com.example.Dosify.Services.ServiceImpl;

import com.example.Dosify.Dto.RequestDtos.CenterRequestDto;
import com.example.Dosify.Dto.ResponseDtos.CenterResponseDto;
import com.example.Dosify.Models.VaccinationCenter;
import com.example.Dosify.Repository.CenterRepository;
import com.example.Dosify.Services.VaccinationCenterService;
import com.example.Dosify.Transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    @Autowired
    CenterRepository centerRepository;
    @Override
    public CenterResponseDto addVaccinationCenter(CenterRequestDto centerRequestDto) {
        VaccinationCenter vaccinationCenter= VaccinationCenterTransformer.CenterRequestDtoToVaccinationCenter(centerRequestDto);
        VaccinationCenter savedVaccinationCenter=centerRepository.save(vaccinationCenter);
        return VaccinationCenterTransformer.vaccinationCenterToCenterResponseDto(vaccinationCenter);
    }
}
