package com.geektrust.backend.services;

import java.util.HashMap;

import com.geektrust.backend.entities.Passenger;

public interface BalanceService extends CRUDRepository<Passenger, String> {
    public Passenger createPassenger(String metroCardNumber, int balance);

    public void updatePassenger(Passenger passenger);

    public HashMap<String, Passenger> getAll();
}
