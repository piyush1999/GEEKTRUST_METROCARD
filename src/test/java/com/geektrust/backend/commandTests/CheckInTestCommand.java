package com.geektrust.backend.commandTests;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.Airport;
import com.geektrust.backend.entities.CentralStation;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.entities.SourceStation;
import com.geektrust.backend.services.BalanceService;
import com.geektrust.backend.services.BalanceServiceImpl;
import com.geektrust.backend.services.CheckInService;
import com.geektrust.backend.services.CheckInServiceImpl;


@ExtendWith(MockitoExtension.class)
@DisplayName("CheckIn command Test")
public class CheckInTestCommand {
    
    @InjectMocks
    private CheckInServiceImpl checkInServiceMock;

    @Mock
    private BalanceServiceImpl balanceServiceMock;

    @Mock
    private Airport airport;

    @Mock
    private CentralStation centralStation;

    @BeforeEach
    void setup() {
        HashMap<String, Passenger> passengermMap = new HashMap<String, Passenger>() {
            {
                put("MC1", new Passenger("MC1", 500, 1));
                put("MC2", new Passenger("MC2", 200, 1));
                put("MC3", new Passenger("MC3", 300, 1));
                put("MC4", new Passenger("MC4", 400, 1));
                put("MC5", new Passenger("MC5", 500, 1));

            }
        };
        balanceServiceMock = new BalanceServiceImpl(passengermMap);
    }

    @Test
    @DisplayName("this method will checkin the passenger")
    public void checkedInCommandTest()
    {
       
       Passenger expectedPassenger=new Passenger("MC1", 500, 1);
       HashMap<String, Passenger> passengerMap = balanceServiceMock.getAll();
       System.out.println(expectedPassenger);
       Passenger actualpassenger=checkInServiceMock.passengerCheckedIn(passengerMap,"MC1", PassengerType.ADULT, SourceStation.CENTRAL) ;
       System.out.println(actualpassenger);
        Assertions.assertEquals(expectedPassenger, expectedPassenger);
    } 

}
