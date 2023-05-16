package com.example.Dosify.Transformer;

import com.example.Dosify.Models.Dose2;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class Dose2Transformer {
    public static Dose2 createDose2(){
        return Dose2.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .build();
    }

}
