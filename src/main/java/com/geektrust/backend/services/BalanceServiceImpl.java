package com.geektrust.backend.services;

import java.util.HashMap;
import java.util.Optional;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.entities.Passenger;

public class BalanceServiceImpl implements BalanceService {

    private HashMap<String, Passenger> passengerMap;
    public BalanceServiceImpl() {
        this.passengerMap = new HashMap<String, Passenger>();
    }

    public BalanceServiceImpl(HashMap<String, Passenger> passengerMap) {
        this.passengerMap = passengerMap;
    }

    @Override
    public Passenger createPassenger(String metroCardNumber, int balance) {
        Passenger newPassenger = new Passenger(metroCardNumber, balance, Constants.ONE);
        passengerMap.put(metroCardNumber, newPassenger);
        // System.out.println("Passenger Map(during creation) = " + passengerMap);
        return newPassenger;
    }

    @Override
    public Optional<Passenger> findById(String id) {
        return Optional.ofNullable(passengerMap.get(id));
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        passengerMap.put(passenger.getMetroCardNumber(), passenger);
        // System.out.println("Passenger Map(during updation) = " + passengerMap);
    }

    @Override
    public HashMap<String, Passenger> getAll() {
        return passengerMap;
    }
}
