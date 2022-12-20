package com.geektrust.backend.entityTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.Airport;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test airport entity")
public class AirportTest {
   
    @Test
    @DisplayName("testing getairportAdultNumber method")
    public void getairportAdultNumbertest() {
        int expected = 1;
        Airport airport = new Airport(1,1,1,100,20);
        Assertions.assertEquals(expected, airport.getairportAdultNumber());
    }

    @Test
    @DisplayName("testing getairportKidNumber method")
    public void getairportKidNumbertest() {
        int expected = 1;
        Airport airport = new Airport(1,1,1,100,20);
        Assertions.assertEquals(expected, airport.getairportKidNumber());
    }

    @Test
    @DisplayName("testing getairportSeniorCitizenNumber method")
    public void getairportSeniorCitizenNumbertest() {
        int expected = 1;
        Airport airport = new Airport(1,1,1,100,20);
        Assertions.assertEquals(expected, airport.getairportSeniorCitizenNumber());
    }

    @Test
    @DisplayName("testing getairportTotalCollection method")
    public void getairportTotalCollectiontest() {
        int expected = 100;
        Airport airport = new Airport(1,1,1,100,20);
        Assertions.assertEquals(expected, airport.getairportTotalCollection());
    }

    @Test
    @DisplayName("testing getairportDiscount method")
    public void getairportDiscounttest() {
        int expected = 20;
        Airport airport = new Airport(1,1,1,100,20);
        Assertions.assertEquals(expected, airport.getairportDiscount());
    }

}
