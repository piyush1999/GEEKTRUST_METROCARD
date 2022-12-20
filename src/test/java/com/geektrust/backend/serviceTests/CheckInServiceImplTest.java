package com.geektrust.backend.serviceTests;

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
import com.geektrust.backend.services.BalanceServiceImpl;
import com.geektrust.backend.services.CheckInServiceImpl;

@ExtendWith(MockitoExtension.class)
@DisplayName("checkIn Service Test")
public class CheckInServiceImplTest {

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
    @DisplayName("Passenger CheckedIn Test")
    public void passengerCheckedInTest() {

        Passenger expectedPassenger = new Passenger("MC1", 300, 2);
        HashMap<String, Passenger> passengerMap = balanceServiceMock.getAll();
        System.out.println(passengerMap);
        Passenger actuPassenger = checkInServiceMock.passengerCheckedIn(passengerMap, "MC1",
                PassengerType.ADULT, SourceStation.CENTRAL);
        System.out.println(actuPassenger);
        Assertions.assertEquals(expectedPassenger.getBalance(), actuPassenger.getBalance());
    }

    @Test
    @DisplayName("test recherage metro card")
    public void rechargeMetroCardTest() {
        Passenger expectedPassenger = new Passenger("MC6", 200, 5);
        HashMap<String, Passenger> passengerMap = balanceServiceMock.getAll();
        Passenger passenger = new Passenger("MC6", 100, 5);
        System.out.println(passengerMap);
        Passenger actuPassenger = checkInServiceMock.rechargeMetroCard(passenger, PassengerType.ADULT, 200,
                SourceStation.AIRPORT);
        System.out.println(actuPassenger);
        Assertions.assertEquals(expectedPassenger.getBalance(), actuPassenger.getBalance());
    }

    @Test
    @DisplayName("test checkamountto pay")
    public void check_amt_to_pay_Test() {
        Passenger passenger = new Passenger("MC6", 500, 6);
        int actual = checkInServiceMock.checkAmountToPay(passenger, PassengerType.KID, SourceStation.CENTRAL);
        System.out.println(actual);
        Assertions.assertEquals(actual, 25);
    }

    @Test
    @DisplayName("test total discount")
    public void countTotalDiscount() {
        int actual = checkInServiceMock.increaceTotalDiscount(SourceStation.CENTRAL, 200);
        System.out.println(actual);
        Assertions.assertEquals(actual, 4);
    }

    @Test
    @DisplayName("PASSENGER AFTER TRIP")
    public void passengerCheckedInTest_02() {
        Passenger expected = new Passenger("MC6", 300, 7);
        Passenger passenger = new Passenger("MC6", 500, 6);
        Passenger actual = checkInServiceMock.passengerCheckedIn(passenger, PassengerType.ADULT, 200,
                SourceStation.AIRPORT);
        // System.out.println(actual);
        Assertions.assertEquals(expected.getBalance(), actual.getBalance());
    }

    @Test
    @DisplayName("RECHARGE_IN_BUILT")
    public void rechargeInBuilt() {
        Passenger expected = new Passenger("MC6", 300, 7);
        Passenger passenger = new Passenger("MC6", 500, 6);
        Passenger actual = checkInServiceMock.rechargeInBuilt(passenger, 300);
        // System.out.println(actual);
        Assertions.assertEquals(expected.getBalance(), actual.getBalance());
    }

}