package org.backendlld.bookmyshow.repositories;

import org.backendlld.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
