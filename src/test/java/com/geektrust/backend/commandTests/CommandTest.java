package com.geektrust.backend.commandTests;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.commands.CheckinCommand;
import com.geektrust.backend.commands.CreatePassengerCommand;
import com.geektrust.backend.commands.PrintSummaryCommand;
import com.geektrust.backend.entities.Airport;
import com.geektrust.backend.entities.CentralStation;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.entities.SourceStation;
import com.geektrust.backend.services.BalanceServiceImpl;
import com.geektrust.backend.services.CheckInServiceImpl;

@ExtendWith(MockitoExtension.class)
@DisplayName("All Command Tests")
public class CommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @InjectMocks
    private CreatePassengerCommand createPassengerCommand;

    @InjectMocks
    private CheckinCommand checkinCommand;

    @InjectMocks
    private PrintSummaryCommand printSummaryCommand;

    @Mock
    private CheckInServiceImpl checkInServiceMock;

    @Mock
    private BalanceServiceImpl balanceServiceMock;

    @Mock
    private Airport airport;

    @Mock
    private CentralStation centralStation;

    @BeforeEach
    public void setUp() {
        HashMap<String, Passenger> passengermMap = new HashMap<String, Passenger>() {
            {
                put("MC1", new Passenger("MC1", 500, 1));

            }
        };
        balanceServiceMock = new BalanceServiceImpl(passengermMap);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Method should test create passenger command")
    public void createCourseCommandTest() {
        Passenger expectedPassenger = new Passenger("MC1", 500, 1);
        when(balanceServiceMock.createPassenger("MC1", 500)).thenReturn(expectedPassenger);
        createPassengerCommand.execute(List.of("BALANCE", "MC1", String.valueOf(500)));
        Assertions.assertEquals(expectedPassenger.getBalance(), 500);
    }

    @Test
    @DisplayName("Method should test checkin with metro card command")
    public void CheckInCommandTest() {
        Passenger expectedPassenger = new Passenger("MC1", 500, 1);
        // HashMap<String, Passenger> passengerMap = balanceServiceMock.getAll();
        // doReturn(expectedPassenger).when(
        // checkInServiceMock.passengerCheckedIn(passengerMap, "MC1",
        // PassengerType.ADULT, SourceStation.CENTRAL));
        checkinCommand.execute(
                List.of("CHECK_IN", "MC1", String.valueOf(PassengerType.ADULT), String.valueOf(SourceStation.CENTRAL)));
        Assertions.assertEquals(expectedPassenger.getMetroCardNumber(), "MC1");
    }

    @Test
    @DisplayName("method should test printsummary")
    public void printsummaryTest() {
        // Passenger expectedPassenger = new Passenger("MC1", 500, 1);
        // HashMap<String, Passenger> passengerMap = balanceServiceMock.getAll();
        // when(checkInServiceMock.passengerCheckedIn(passengerMap, "MC1",
        // PassengerType.ADULT, SourceStation.CENTRAL))
        // .thenReturn(expectedPassenger);
        String expecString = " ";
        printSummaryCommand.execute(List.of("PRINT_SUMMARY"));
        Assertions.assertEquals(expecString, " ");
    }
}
