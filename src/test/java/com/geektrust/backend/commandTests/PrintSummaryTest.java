package com.geektrust.backend.commandTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.services.BalanceService;
import com.geektrust.backend.services.CheckInService;

@ExtendWith(MockitoExtension.class)
@DisplayName("CheckIn command Test")
public class PrintSummaryTest {
    @Mock
    private BalanceService balanceService;

    @Mock
    private CheckInService checkInServiceMock;

    @Test
    @DisplayName("method to check print method summary")
    public void printsummarytest() {
        String expecString = null;
        String actualString = checkInServiceMock.printSummaryOfPassengers();
        Assertions.assertEquals(expecString, actualString);
    }

}
