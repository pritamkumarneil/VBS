package com.example.Dosify.Services;

import com.example.Dosify.Enums.VaccineType;
import com.example.Dosify.Models.Dose1;
import com.example.Dosify.Models.User;

public interface Dose1Service {
    public Dose1 createDose1(User user, VaccineType vaccineType);
}
