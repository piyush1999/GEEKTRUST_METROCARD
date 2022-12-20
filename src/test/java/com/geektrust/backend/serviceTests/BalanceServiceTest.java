package com.geektrust.backend.serviceTests;

import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.services.BalanceServiceImpl;

@ExtendWith(MockitoExtension.class)
@DisplayName("balance Service Test")
public class BalanceServiceTest {
    private BalanceServiceImpl balanceServiceMock;

    @BeforeEach
    void setup() {
        HashMap<String, Passenger> passengermMap = new HashMap<String, Passenger>() {
            {
                put("MC1", new Passenger("MC1", 100, 1));
                put("MC2", new Passenger("MC2", 200, 1));
                put("MC3", new Passenger("MC3", 300, 1));
                put("MC4", new Passenger("MC4", 400, 1));
                put("MC5", new Passenger("MC5", 500, 1));
            }
        };
        balanceServiceMock = new BalanceServiceImpl(passengermMap);
    }

    @Test
    @DisplayName("Test for COUNTER Passengers")
    public void RegisterPassengerbytripcounter() {
        // ARRANGE THE EXPECTED RESULT
        Passenger passenger = new Passenger("MC1", 500, 1);
        // ACT THE FLOW(TEST THE CODE)
        Passenger actualPassenger = balanceServiceMock.createPassenger("MC1", 500);
        // ASSERT THE TEST
        Assertions.assertEquals(passenger.getTripCounter(), actualPassenger.getTripCounter());
    }

    @Test
    @DisplayName("Test for Balance Passengers")
    public void RegisterPassenger() {
        // ARRANGE THE EXPECTED RESULT
        Passenger passenger = new Passenger("MC1", 500, 1);
        // ACT THE FLOW(TEST THE CODE)
        Passenger actualPassenger = balanceServiceMock.createPassenger("MC1", 500);
        // ASSERT THE TEST
        Assertions.assertEquals(passenger.getBalance(), actualPassenger.getBalance());
    }

    @Test
    @DisplayName("Find Passenger By ID")
    public void findPassengerById() {
        // ARRANGE THE EXPECTED RESULT
        Passenger expectedPassenger = new Passenger("MC1", 100, 2);
        // ACT THE FLOW(TEST THE CODE)
        Optional<Passenger> actualPassenger = balanceServiceMock.findById("MC1");
        // ASSERT THE TEST
        Assertions.assertEquals(expectedPassenger.getMetroCardNumber(), actualPassenger.get().getMetroCardNumber());
    }

    @Test
    @DisplayName("Update Passenger Test Method")
    public void updatePassengerTest() {
        // ARRANGE THE EXPECTED RESULT
        Passenger expectedPassenger = new Passenger("MC1", 500, 2);
        // ACT THE FLOW(TEST THE CODE)
        Passenger passenger = new Passenger("MC1", 500, 2);
        balanceServiceMock.updatePassenger(passenger);
        Passenger actualPassenger = balanceServiceMock.findById("MC1").get();
        // ASSERT THE TEST
        Assertions.assertEquals(expectedPassenger.getMetroCardNumber(), actualPassenger.getMetroCardNumber());
    }

    @Test
    @DisplayName("When Passenger not found during updation..")
    public void updatePassengerButNotFoundTest() {
        // ARRANGE THE EXPECTED RESULT
        Passenger expectedPassenger = new Passenger("MC1", 500, 2);
        // ACT THE FLOW(TEST THE CODE)
        Passenger passenger = new Passenger("MC2", 500, 2);
        balanceServiceMock.updatePassenger(passenger);
        Passenger actualPassenger = balanceServiceMock.findById("MC1").get();
        // ASSERT THE TEST
        Assertions.assertEquals(expectedPassenger.getMetroCardNumber(), actualPassenger.getMetroCardNumber());

    }

    @Test
    @DisplayName("RETRIEVE ALL THE PASSENGERS")
    public void getAllPassengers() {
        int EXPECTED = 5;
        HashMap<String, Passenger> gMap = balanceServiceMock.getAll();
        Assertions.assertEquals(EXPECTED, gMap.size());
    }

}