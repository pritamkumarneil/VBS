package com.example.Dosify.Transformer;

import com.example.Dosify.Models.Dose1;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class Dose1Transformer {
    public static Dose1 createDose1(){

        return Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .build();
    }
}
