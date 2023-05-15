package com.example.Dosify.Models;

import com.example.Dosify.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user")
@SuperBuilder
public class User extends  Person{
//    @Builder
//    public User(String name,int age,String emailId,String mobNo,Gender gender){
//        super(name,age,emailId,mobNo,gender);
//    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//
//    @Column(name="name")
//    String name;
//
//    @Column(name = "age")
//    int age;
//
//    @Column(name = "email_id", unique = true,nullable = false)
//    String emailId;
//
//    @Column(name = "mob_no",unique = true,nullable = false)
//    String mobNo;
//
//    @Column(name="gender")
//    @Enumerated(EnumType.STRING)
//    Gender gender;

    @Column(name = "is_dose1_taken")
    boolean isDose1Taken;// no need to take from client as input

    @Column(name = "is_dose2_taken")
    boolean isDose2Taken;// no need to take as input from client

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Appointment> appointments=new ArrayList<>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Dose1 dose1;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Dose2 dose2;

}
