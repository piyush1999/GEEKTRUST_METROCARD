package com.geektrust.backend.entities;

public class Airport {
    private int airportAdultNumber;
    private int airportKidNumber;
    private int airportSeniorCitizenNumber;
    private int airportTotalCollection;
    private int airportDiscount;

    public Airport(int airportAdultNumber, int airportKidNumber, int airportSeniorCitizenNumber,
            int airportTotalCollection, int airportDiscount) {
        this.airportAdultNumber = airportAdultNumber;
        this.airportKidNumber = airportKidNumber;
        this.airportSeniorCitizenNumber = airportSeniorCitizenNumber;
        this.airportTotalCollection = airportTotalCollection;
        this.airportDiscount = airportDiscount;
    }

    public int getairportAdultNumber() {
        return airportAdultNumber;
    }

    public int getairportKidNumber() {
        return airportKidNumber;
    }

    public int getairportSeniorCitizenNumber() {
        return airportSeniorCitizenNumber;
    }

    public int getairportTotalCollection() {
        return airportTotalCollection;
    }

    public int getairportDiscount() {
        return airportDiscount;
    }

    @Override
    public String toString() {
        return "Airport [airportAdultNumber=" + airportAdultNumber + ", airportKidNumber=" + airportKidNumber
                + ", airportSeniorCitizenNumber="
                + airportSeniorCitizenNumber + ", airportTotalCollection=" + airportTotalCollection
                + ", airportDiscount=" + airportDiscount + "]";
    }
}
