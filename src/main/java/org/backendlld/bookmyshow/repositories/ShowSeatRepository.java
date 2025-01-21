package org.backendlld.bookmyshow.repositories;

import org.backendlld.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
}
