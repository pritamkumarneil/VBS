package com.example.Dosify.Repository;

import com.example.Dosify.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmailId(String emailId);
    public User findByMobNo(String mobNo);
    public List<User> findByIsDose1Taken(Boolean taken);
    public List<User> findByIsDose2Taken(boolean b);

    @Query(value = "select * from user u where u.is_dose1_taken=true and u.is_dose2_taken=false",nativeQuery = true)
    List<User> getAllUserWithDose1Only();
    @Query(value = "select * from user u where u.gender='MALE' and u.is_dose1_taken=false",nativeQuery = true)
    List<User> getAllMaleWithNoVaccination();
    @Query(value = "select * from user u where u.gender='FEMALE' and u.is_dose2_take=true",nativeQuery = true)
    List<User> findAllFemaleFullyVaccinated();
}
