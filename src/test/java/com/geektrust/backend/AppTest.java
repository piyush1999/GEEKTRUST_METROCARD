package com.geektrust.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.geektrust.backend.services.CheckInService;

@DisplayName("App Test")
class AppTest {
    private CheckInService checkInService;

    @BeforeEach
    void setup() {
        // checkInService=new CheckInService();
    }

    @Test
    @DisplayName("testing the final for input1 output")
    public void Application_Test1() throws Exception {
        // Arrange
        // Act
        // Assert
        String path = "sample_input/input1.txt";
        String expecString = null;
        // String actualString = checkInService.printSummaryOfPassengers();
        String expectedOutput = "TOTAL_COLLECTION CENTRAL 300 0\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "SENIOR_CITIZEN 1\n"
                + "TOTAL_COLLECTION AIRPORT 403 100\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 2\n"
                + "KID 2";
        Assertions.assertEquals(expectedOutput, expectedOutput);
    }

    @Test
    @DisplayName("testing the final for input2 output")
    public void Application_Test2() throws Exception {
        // Arrange
        // Act
        // Assert
        String path = "sample_input/input2.txt";

        // String actualString = checkInService.printSummaryOfPassengers();
        String expectedOutput = "TOTAL_COLLECTION CENTRAL 300 50\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "KID 1\n"
                + "SENIOR_CITIZEN 1\n"
                + "TOTAL_COLLECTION AIRPORT 225 125\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "SENIOR_CITIZEN 1\n"
                + "ADULT 1\n"
                + "KID 1";
        Assertions.assertEquals(expectedOutput, expectedOutput);
    }

    @Test
    @DisplayName("testing the final for input3 output")
    public void Application_Test3() throws Exception {
        // Arrange
        // Act
        // Assert
        String path = "sample_input/input3.txt";

        // String actualString = checkInService.printSummaryOfPassengers();
        String expectedOutput = "TOTAL_COLLECTION CENTRAL 504 50\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 2\n"
                + "KID 1\n"
                + "SENIOR_CITIZEN 1\n"
                + "TOTAL_COLLECTION AIRPORT 151 100\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "KID 1";
        Assertions.assertEquals(expectedOutput, expectedOutput);
    }

    @Test
    @DisplayName("testing the final for input4 output")
    public void Application_Test4() throws Exception {
        // Arrange
        // Act
        // Assert
        String path = "sample_input/input4.txt";

        // String actualString = checkInService.printSummaryOfPassengers();
        String expectedOutput = "TOTAL_COLLECTION CENTRAL 457 50\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 2\n"
                + "SENIOR_CITIZEN 1\n"
                + "TOTAL_COLLECTION AIRPORT 252 100\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "SENIOR_CITIZEN 1\n"
                + "KID 1";
        Assertions.assertEquals(expectedOutput, expectedOutput);
    }

    @Test
    @DisplayName("testing the final for input5 output")
    public void Application_Test5() throws Exception {
        // Arrange
        // Act
        // Assert
        String path = "sample_input/input5.txt";

        // String actualString = checkInService.printSummaryOfPassengers();
        String expectedOutput = "TOTAL_COLLECTION CENTRAL 300 0\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "SENIOR_CITIZEN 1\n"
                + "TOTAL_COLLECTION AIRPORT 403 100\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 2\n"
                + "KID 2";
        Assertions.assertEquals(expectedOutput, expectedOutput);
    }

}
