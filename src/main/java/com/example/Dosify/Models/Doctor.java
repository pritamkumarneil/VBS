package com.example.Dosify.Models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "doctor")
public class Doctor extends Person{
    // we can here make a person class for user and doctor
    // where all the common attributes will be defined and
    // user and doctor will inherit from that class
    // this is the standard way to write industry level code
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//
//    @Column(name = "name",nullable = false)
//    String name;
//
//    @Column(name="age",nullable = false)
//    int age;
//
//    @Column(name="email_id",unique = true,nullable = false)
//    String emailId;
//
//    @Column(name = "mob_no",unique = true,nullable = false)
//    String mobNo;
//
//    @Column(name = "gender",nullable = false)
//    Gender gender;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    List<Appointment> appointments=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    VaccinationCenter vaccinationCenter;

}
