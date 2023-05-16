package com.example.Dosify.Services.ServiceImpl;

import com.example.Dosify.Enums.VaccineType;
import com.example.Dosify.Models.Dose1;
import com.example.Dosify.Models.User;
import com.example.Dosify.Repository.Dose1Repository;
import com.example.Dosify.Services.Dose1Service;
import com.example.Dosify.Transformer.Dose1Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dose1ServiceImpl implements Dose1Service {
    @Autowired
    Dose1Repository dose1Repository;
    @Override
    public Dose1 createDose1(User user, VaccineType vaccineType) {

        Dose1 dose1= Dose1Transformer.createDose1();
        dose1.setVaccineType(vaccineType);

        return dose1Repository.save(dose1);
    }
}
