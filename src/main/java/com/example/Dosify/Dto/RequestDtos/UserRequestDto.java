package com.example.Dosify.Dto.RequestDtos;

import com.example.Dosify.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {


    String name;

    int age;

    String emailId;

    String mobNo;

    Gender gender;
}
