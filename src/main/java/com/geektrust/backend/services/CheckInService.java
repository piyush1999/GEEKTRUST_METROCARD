package com.geektrust.backend.services;

import java.util.HashMap;

import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.entities.SourceStation;

public interface CheckInService {
    public Passenger passengerCheckedIn(HashMap<String, Passenger> passengerMap, String metroCardNumber,
            PassengerType passengerType, SourceStation sourceStation);

    public Passenger rechargeMetroCard(Passenger passenger, PassengerType passengerType, int amtToPay,
            SourceStation sourceStation);

    public int checkAmountToPay(Passenger passenger, PassengerType passengerType, SourceStation sourceStation);

    public String printSummaryOfPassengers();
}
