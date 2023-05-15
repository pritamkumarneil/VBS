package com.example.Dosify.Dto.RequestDtos;

import com.example.Dosify.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDto {
    int centerId;
    String name;
    int age;
    String emailId;
    String mobNo;
    Gender gender;
}
