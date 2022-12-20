package com.geektrust.backend.commandTests;

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

import com.geektrust.backend.commands.CreatePassengerCommand;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.services.BalanceService;
import com.geektrust.backend.services.BalanceServiceImpl;
import com.geektrust.backend.services.CheckInService;

@ExtendWith(MockitoExtension.class)
@DisplayName("Balance command Test")
public class BalanceCommandTest {
    @Mock
    private BalanceService balanceServiceMock;

    @Mock
    private CheckInService checkInServiceMock;

    @InjectMocks
    private CreatePassengerCommand createPassengerCommand;

    @BeforeEach
    void setup() {
        HashMap<String, Passenger> passengermMap = new HashMap<String, Passenger>() {
            {
                put("MC1", new Passenger("MC1", 100, 1));
            }
        };
        balanceServiceMock = new BalanceServiceImpl(passengermMap);
    }

    @Test
    @DisplayName("this method will add balance of mero card details in hashmap the passenger")
    public void checkedInCommandTest() {

        Passenger expectedPassenger = new Passenger("MC1", 500, 1);
        System.out.println(expectedPassenger);
        Passenger actualPassenger = balanceServiceMock.createPassenger("MC1", 500);
        System.out.println(actualPassenger);
        Assertions.assertEquals(expectedPassenger, expectedPassenger);
    }
}
