package com.example.Dosify.Dto.ResponseDtos;

import com.example.Dosify.Enums.DoseNo;
import com.example.Dosify.Enums.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class AppointmentResponseDto {

    String appointmentNo;
    String userName;
    String doctorName;
    DoseNo doseNo;
    Date dateOfAppointment;
//    DoctorResponseDto doctorResponseDto;
    CenterResponseDto centerResponseDto;
    VaccineType vaccineType;
}
