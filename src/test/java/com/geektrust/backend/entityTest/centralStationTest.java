package com.geektrust.backend.entityTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.CentralStation;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test centralStation entity")
public class centralStationTest {
    @Test
    @DisplayName("testing getcentralStationAdultNumber method")
    public void getcentralStationAdultNumbertest() {
        int expected = 1;
        CentralStation centralStation = new CentralStation(1,1,1,100,20);
        Assertions.assertEquals(expected, centralStation.getcentralAdultNumber());
    }

    @Test
    @DisplayName("testing getcentralStationKidNumber method")
    public void getcentralStationKidNumbertest() {
        int expected = 1;
        CentralStation centralStation = new CentralStation(1,1,1,100,20);
        Assertions.assertEquals(expected, centralStation.getcentralKidNumber());
    }

    @Test
    @DisplayName("testing getcentralStationSeniorCitizenNumber method")
    public void getcentralStationSeniorCitizenNumbertest() {
        int expected = 1;
        CentralStation centralStation = new CentralStation(1,1,1,100,20);
        Assertions.assertEquals(expected, centralStation.getcentralSeniorCitizenNumber());
    }

    @Test
    @DisplayName("testing getcentralStationTotalCollection method")
    public void getcentralStationTotalCollectiontest() {
        int expected = 100;
        CentralStation centralStation = new CentralStation(1,1,1,100,20);
        Assertions.assertEquals(expected, centralStation.getcentralTotalCollection());
    }

    @Test
    @DisplayName("testing getcentralStationDiscount method")
    public void getcentralStationDiscounttest() {
        int expected = 20;
        CentralStation centralStation = new CentralStation(1,1,1,100,20);
        Assertions.assertEquals(expected, centralStation.getcentralDiscount());
    }
}
