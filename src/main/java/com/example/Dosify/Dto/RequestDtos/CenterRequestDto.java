package com.example.Dosify.Dto.RequestDtos;

import com.example.Dosify.Enums.CenterType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterRequestDto {

    String name;
    String location;
    CenterType centerType;
}
