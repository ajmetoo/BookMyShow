package org.backendlld.bookmyshow.repositories;

import org.backendlld.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
