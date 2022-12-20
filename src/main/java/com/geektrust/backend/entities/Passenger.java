package com.geektrust.backend.entities;

public class Passenger {

    private final String metroCardNumber;
    private final int balance;
    private final int tripCounter;

    public Passenger(String metroCardNumber, int balance, int tripCounter) {
        this.metroCardNumber = metroCardNumber;
        this.balance = balance;
        this.tripCounter = tripCounter;
    }

    public String getMetroCardNumber() {
        return metroCardNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int getTripCounter() {
        return tripCounter;
    }

    @Override
    public String toString() {
        return "Passenger [metroCardNumber=" + metroCardNumber + ", balance=" + balance + "]";
    }

}
