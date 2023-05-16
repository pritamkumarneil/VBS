package com.example.Dosify.Dto.ResponseDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterResponseDto {
    String name;
    String location;
    String message;
}
