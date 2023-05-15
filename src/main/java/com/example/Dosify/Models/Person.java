package com.example.Dosify.Models;

import com.example.Dosify.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PROTECTED)
@SuperBuilder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name",nullable = false)
    protected String name;

    @Column(name = "age",nullable = false)
    protected int age;


    @Column(name="email_id",nullable = false,unique = true)
    protected String emailId;

    @Column(name="mob_no",unique = true,nullable = false,length = 10)
    protected String mobNo;

    @Column(name="gender",nullable = false)
    @Enumerated(EnumType.STRING)
    protected Gender gender;

}
