package com.example.Dosify.Transformer;

import com.example.Dosify.Dto.RequestDtos.DoctorRequestDto;
import com.example.Dosify.Dto.ResponseDtos.DoctorResponseDto;
import com.example.Dosify.Models.Doctor;

import javax.print.Doc;

public class DoctorTransformer {
    public static Doctor doctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto){
        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .emailId(doctorRequestDto.getEmailId())
                .mobNo(doctorRequestDto.getMobNo())
                .gender(doctorRequestDto.getGender())
                .build();
    }
    public static DoctorResponseDto doctorToDoctorResponseDto(Doctor doctor){
        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .age(doctor.getAge())
                .emailId(doctor.getEmailId())
                .mobNo(doctor.getMobNo())
                .gender(doctor.getGender())
                .centerResponseDto(VaccinationCenterTransformer.vaccinationCenterToCenterResponseDto(doctor.getVaccinationCenter()))
                .build();
    }

}
