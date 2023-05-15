package com.example.Dosify.Dto.ResponseDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
    String name;
    int age;
    String emailId;
    String mobNo;
    String message;

}
