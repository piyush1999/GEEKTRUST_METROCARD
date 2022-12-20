package com.geektrust.backend.entities;

public class CentralStation {
    private int centralAdultNumber;
    private int centralKidNumber;
    private int centralSeniorCitizenNumber;
    private int centralTotalCollection;
    private int centralDiscount;

    public CentralStation(int centralAdultNumber, int centralKidNumber, int centralSeniorCitizenNumber,
            int centralTotalCollection, int centralDiscount) {
        this.centralAdultNumber = centralAdultNumber;
        this.centralKidNumber = centralKidNumber;
        this.centralSeniorCitizenNumber = centralSeniorCitizenNumber;
        this.centralTotalCollection = centralTotalCollection;
        this.centralDiscount = centralDiscount;
    }

    public int getcentralAdultNumber() {
        return centralAdultNumber;
    }

    public int getcentralKidNumber() {
        return centralKidNumber;
    }

    public int getcentralSeniorCitizenNumber() {
        return centralSeniorCitizenNumber;
    }

    public int getcentralTotalCollection() {
        return centralTotalCollection;
    }

    public int getcentralDiscount() {
        return centralDiscount;
    }

    @Override
    public String toString() {
        return "CentralStation [centralAdultNumber=" + centralAdultNumber + ", centralKidNumber=" + centralKidNumber
                + ", centralSeniorCitizenNumber="
                + centralSeniorCitizenNumber + ", centralTotalCollection=" + centralTotalCollection
                + ", centralDiscount=" + centralDiscount + "]";
    }
}
