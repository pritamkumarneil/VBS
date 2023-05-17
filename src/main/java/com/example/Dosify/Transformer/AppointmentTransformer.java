package com.example.Dosify.Transformer;

import com.example.Dosify.Dto.RequestDtos.AppointmentRequestDto;
import com.example.Dosify.Dto.ResponseDtos.AppointmentResponseDto;
import com.example.Dosify.Dto.ResponseDtos.CenterResponseDto;
import com.example.Dosify.Enums.VaccineType;
import com.example.Dosify.Models.Appointment;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class AppointmentTransformer {
    public static Appointment appointmentRequestDtoToAppointment(AppointmentRequestDto appointmentRequestDto){
        return Appointment.builder()
                .doseNo(appointmentRequestDto.getDoseNo())
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .build();
    }
    public static AppointmentResponseDto appointmentToAppointmentResponseDto(Appointment appointment){
        CenterResponseDto centerResponseDto=VaccinationCenterTransformer
                .vaccinationCenterToCenterResponseDto(
                        appointment.getDoctor().getVaccinationCenter()
                );
        VaccineType vaccineType;
        if(appointment.getUser().isDose2Taken()){
            vaccineType=appointment.getUser().getDose2().getVaccineType();
        }
        else{
            vaccineType=appointment.getUser().getDose1().getVaccineType();
        }
        return AppointmentResponseDto.builder()
                .appointmentNo(appointment.getAppointmentNo())
                .vaccineType(vaccineType)
                .centerResponseDto(centerResponseDto)
                .doctorName(appointment.getDoctor().getName())
                .userName(appointment.getUser().getName())
                .doseNo(appointment.getDoseNo())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .build();
    }
}
