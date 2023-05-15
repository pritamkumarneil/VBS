package com.example.Dosify.Dto.ResponseDtos;

import com.example.Dosify.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponseDto {
    String name;
    int age;
    String emailId;
    String mobNo;
    Gender gender;
    String message;
    CenterResponseDto centerResponseDto;

}
