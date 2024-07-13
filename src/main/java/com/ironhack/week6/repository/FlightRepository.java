package com.ironhack.week6.repository;

import com.ironhack.week6.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String aircraft);
    List<Flight> findByFlightMileageGreaterThan(Integer mileage);
}




