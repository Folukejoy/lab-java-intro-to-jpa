package com.ironhack.week6;

import com.ironhack.week6.model.Flight;
import com.ironhack.week6.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateNewFlight() {
        Flight flight = new Flight("AA123", "Boeing 737", 150, 600);
        flightRepository.save(flight);
        assertTrue(flightRepository.findById(flight.getFlightId()).isPresent());
    }

    @Test
    public void testFindFlightByNumber() {
        Flight flight = new Flight("UA456", "Airbus A320", 180, 800);
        flightRepository.save(flight);

        List<Flight> flights = flightRepository.findByFlightNumber("UA456");
        assertEquals(1, flights.size());
        assertEquals("UA456", flights.get(0).getFlightNumber());
    }

    @Test
    public void testFindAircraftContainingName() {
        Flight flight = new Flight("DL789", "Boeing 777", 200, 1200);
        flightRepository.save(flight);

        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertEquals(1, flights.size());
        assertTrue(flights.get(0).getAircraft().contains("Boeing"));
    }

    @Test
    public void testFindFlightsWithDistanceGreaterThan500Miles() {
        Flight flight = new Flight("SW345", "Boeing 737", 150, 600);
        flightRepository.save(flight);

        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertEquals(1, flights.size());
        assertTrue(flights.get(0).getFlightMileage() > 500);
    }
}




