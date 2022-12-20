package com.geektrust.backend.entityTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.Passenger;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test passenger entity")
public class PassengerTest {
    

    @Test
    @DisplayName("TESTING GETCARDNUMBER METHOD")
    public void getMetroCardNumbertest() {
        String expected = "MC1";
        Passenger passenger = new Passenger("MC1", 100, 2);
        Assertions.assertEquals(expected, passenger.getMetroCardNumber());
    }

    @Test
    @DisplayName("TESTING GETBALANCE METHOD")
    public void getBalanceTest() {
        int expected = 100;
        Passenger passenger = new Passenger("MC1", 100, 2);
        Assertions.assertEquals(expected, passenger.getBalance());
    }

    @Test
    @DisplayName("TESTING GETTRIPCOUNTER METHOD")
    public void getTripCounterTest() {
        int expected = 2;
        Passenger passenger = new Passenger("MC1", 100, 2);
        Assertions.assertEquals(expected, passenger.getTripCounter());
    }

}
