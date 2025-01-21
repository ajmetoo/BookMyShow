package org.backendlld.bookmyshow.repositories;

import org.backendlld.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByEmailAndPassword(String email,String phoneNumber);

    Optional<User> getUserByEmailOrPhoneNumber(String email, String phoneNumber);
}

