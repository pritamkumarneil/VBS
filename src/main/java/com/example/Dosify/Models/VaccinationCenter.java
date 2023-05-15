package com.example.Dosify.Models;

import com.example.Dosify.Enums.CenterType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "vaccination_center")
@Builder
public class VaccinationCenter {


    // parent to doctor

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "location")
    String location;

    @Enumerated(EnumType.STRING)
    CenterType centerType;

    @OneToMany(mappedBy = "vaccinationCenter",cascade = CascadeType.ALL)
    List<Doctor> doctors=new ArrayList<>();

//    @OneToMany(mappedBy = "vaccinationCenter",cascade = CascadeType.ALL)
//    List<Appointment> appointments=new ArrayList<>();
}
