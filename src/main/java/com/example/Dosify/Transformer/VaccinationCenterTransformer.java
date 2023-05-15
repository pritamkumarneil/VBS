package com.example.Dosify.Transformer;

import com.example.Dosify.Dto.RequestDtos.CenterRequestDto;
import com.example.Dosify.Dto.ResponseDtos.CenterResponseDto;
import com.example.Dosify.Models.VaccinationCenter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VaccinationCenterTransformer {
    public static VaccinationCenter CenterRequestDtoToVaccinationCenter(CenterRequestDto centerRequestDto){
        return VaccinationCenter.builder()
                .name(centerRequestDto.getName())
                .centerType(centerRequestDto.getCenterType())
                .location(centerRequestDto.getLocation())
                .build();
    }
    public static CenterResponseDto vaccinationCenterToCenterResponseDto(VaccinationCenter vaccinationCenter){
        return CenterResponseDto.builder()
                .location(vaccinationCenter.getLocation())
                .name(vaccinationCenter.getName())
                .build();
    }
}
