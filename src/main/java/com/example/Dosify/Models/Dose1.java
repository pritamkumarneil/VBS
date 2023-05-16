package com.example.Dosify.Models;

import com.example.Dosify.Enums.VaccineType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Dose1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="dose_id",unique = true,nullable = false)
    String doseId;

    @Column(name = "vaccine_type")
    @Enumerated(EnumType.STRING)
    VaccineType vaccineType;

    @CreationTimestamp
    Date vaccinationDate;

    @OneToOne
    @JoinColumn
    User user;


}
