package com.example.Dosify.Repository;

import com.example.Dosify.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmailId(String emailId);
    public User findByMobNo(String mobNo);
    public List<User> findByIsDose1Taken(Boolean taken);
}
