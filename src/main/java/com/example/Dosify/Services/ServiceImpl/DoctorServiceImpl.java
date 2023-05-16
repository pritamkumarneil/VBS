package com.example.Dosify.Services.ServiceImpl;

import com.example.Dosify.Dto.RequestDtos.DoctorRequestDto;
import com.example.Dosify.Dto.ResponseDtos.CenterResponseDto;
import com.example.Dosify.Dto.ResponseDtos.DoctorResponseDto;
import com.example.Dosify.Exception.CenterNotPresentException;
import com.example.Dosify.Models.Doctor;
import com.example.Dosify.Models.VaccinationCenter;
import com.example.Dosify.Repository.CenterRepository;
import com.example.Dosify.Repository.DoctorRepository;
import com.example.Dosify.Services.DoctorService;
import com.example.Dosify.Transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    CenterRepository centerRepository;
    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException {
        // first get the center from center id;
//        VaccinationCenter vaccinationCenter=centerRepository.findById(doctorRequestDto.getCenterId()).get();

        Optional<VaccinationCenter> optionalCenter = centerRepository.findById(doctorRequestDto.getCenterId());
        if(optionalCenter.isEmpty()){
            throw new CenterNotPresentException("Invalid Center Id");
        }
        VaccinationCenter vaccinationCenter = optionalCenter.get();

        Doctor doctor = DoctorTransformer.doctorRequestDtoToDoctor(doctorRequestDto);
        // now mapping part
        vaccinationCenter.getDoctors().add(doctor);
        doctor.setVaccinationCenter(vaccinationCenter);
//        Doctor savedDoctor=doctorRepository.save(doctor);
        centerRepository.save(vaccinationCenter);
        return DoctorTransformer.doctorToDoctorResponseDto(doctor);
    }

    @Override
    public List<DoctorResponseDto> getAllDoctors() {
        List<DoctorResponseDto> ans=new ArrayList<>();
        List<Doctor> doctors=doctorRepository.findAll();
        for(Doctor doctor: doctors){
            DoctorResponseDto doctorResponseDto=DoctorTransformer.doctorToDoctorResponseDto(doctor);
            ans.add(doctorResponseDto);
        }
        return ans;
    }
}
