package com.example.Dosify.Services.ServiceImpl;

import com.example.Dosify.Models.Dose2;
import com.example.Dosify.Repository.Dose2Repository;
import com.example.Dosify.Services.Dose2Service;
import com.example.Dosify.Transformer.Dose2Transformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dose2ServiceImpl implements Dose2Service {
    @Autowired
    Dose2Repository dose2Repository;
    @Override
    public Dose2 createDose2() {

        Dose2 dose2= Dose2Transformer.createDose2();
        return dose2Repository.save(dose2);

    }
}
