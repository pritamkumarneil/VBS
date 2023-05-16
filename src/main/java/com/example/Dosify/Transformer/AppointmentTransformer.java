package com.example.Dosify.Transformer;

import com.example.Dosify.Dto.RequestDtos.AppointmentRequestDto;
import com.example.Dosify.Dto.ResponseDtos.AppointmentResponseDto;
import com.example.Dosify.Dto.ResponseDtos.CenterResponseDto;
import com.example.Dosify.Models.Appointment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AppointmentTransformer {
    public static Appointment appointmentRequestDtoToAppointment(AppointmentRequestDto appointmentRequestDto){
        return Appointment.builder()
                .doseNo(appointmentRequestDto.getDoseNo())
                .build();
    }
    public static AppointmentResponseDto appointmentToAppointmentResponseDto(Appointment appointment){
        CenterResponseDto centerResponseDto=VaccinationCenterTransformer
                .vaccinationCenterToCenterResponseDto(
                        appointment.getDoctor().getVaccinationCenter()
                );

        return AppointmentResponseDto.builder()
                .appointmentNo(appointment.getAppointmentNo())
                .centerResponseDto(centerResponseDto)
                .doctorName(appointment.getDoctor().getName())
                .userName(appointment.getUser().getName())
                .doseNo(appointment.getDoseNo())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .build();
    }
}
