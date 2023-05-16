package com.example.Dosify.Dto.RequestDtos;

import com.example.Dosify.Enums.DoseNo;
import com.example.Dosify.Enums.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequestDto {
    DoseNo doseNo;
    int userId;
    int doctorId;
    VaccineType vaccineType;
}
