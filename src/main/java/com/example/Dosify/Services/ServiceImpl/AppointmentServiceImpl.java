package com.example.Dosify.Services.ServiceImpl;

import com.example.Dosify.Dto.RequestDtos.AppointmentRequestDto;
import com.example.Dosify.Dto.ResponseDtos.AppointmentResponseDto;
import com.example.Dosify.Enums.DoseNo;
import com.example.Dosify.Exception.DoctorNotFoundException;
import com.example.Dosify.Exception.Dose1NotTakenException;
import com.example.Dosify.Exception.UserNotFoundException;
import com.example.Dosify.Models.*;
import com.example.Dosify.Repository.AppointmentRepository;
import com.example.Dosify.Repository.DoctorRepository;
import com.example.Dosify.Repository.UserRepository;
import com.example.Dosify.Services.AppointmentService;
import com.example.Dosify.Services.Dose1Service;
import com.example.Dosify.Services.Dose2Service;
import com.example.Dosify.Transformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;
    @Autowired
    private JavaMailSender emailSender;
    @Override
    public AppointmentResponseDto addAppointment(AppointmentRequestDto appointmentRequestDto) throws Exception{
        // first check if user exist or not with given user id;
        Optional<User> optionalUser = userRepository.findById(appointmentRequestDto.getUserId());
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User Doesn't Exist with give Id");
        }
        User user=optionalUser.get();

        // then check if doctor exist or not with give doctor id;
        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());
        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Doctor doesn't Exist with given Id");
        }
        Doctor doctor= optionalDoctor.get();
        // if doctor and user exist
        // then if user wants to take dose 1
        if(appointmentRequestDto.getDoseNo()== DoseNo.DOSE_1){
            if(user.isDose1Taken())
                throw new Dose1NotTakenException("Already taken this dose. book for dose 2");
            Dose1 dose1=dose1Service.createDose1(user,appointmentRequestDto.getVaccineType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
            dose1.setUser(user);
        }
        else {
            if(!user.isDose1Taken()){
                throw new Dose1NotTakenException("First Take Dose1. Please!!!");
            }
            Dose2 dose2=dose2Service.createDose2();
            dose2.setUser(user);
            dose2.setVaccineType(appointmentRequestDto.getVaccineType());
            user.setDose2(dose2);
            user.setDose2Taken(true);
        }


        Appointment appointment= AppointmentTransformer.appointmentRequestDtoToAppointment(appointmentRequestDto);
        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);
        appointment.setUser(user);
        user.getAppointments().add(appointment);
        User savedUser=userRepository.save(user);
        doctorRepository.save(doctor);
        // now send the mail to the user for the confirmation
        String text="Hey "+user.getName()+"!!\n"+
                "Your Booking for "+appointmentRequestDto.getVaccineType().toString()+" has Successfully Done.\n" +
                "Center Name: "+ appointment.getDoctor().getVaccinationCenter().getName()
                +"\nDoctor Name: "+ appointment.getDoctor().getName()
                +"\nDate : "+ appointment.getDateOfAppointment().toString()
                +"\nLocation: "+appointment.getDoctor().getVaccinationCenter().getLocation();
        String subject="Vaccination Booked!!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@gmail.com");
        message.setTo(user.getEmailId());
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);



        return AppointmentTransformer.appointmentToAppointmentResponseDto(appointment);

    }
}
