package com.geektrust.backend.services;

import java.util.HashMap;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.constants.PassengerFare;
import com.geektrust.backend.entities.Airport;
import com.geektrust.backend.entities.CentralStation;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.entities.SourceStation;

public class CheckInServiceImpl implements CheckInService {

    private BalanceService balanceService;
    private Airport airport;
    private CentralStation centralStation;

    public CheckInServiceImpl(BalanceService balanceService, Airport airport, CentralStation centralStation) {
        this.airport = airport;
        this.centralStation = centralStation;
        this.balanceService = balanceService;
    }

    public Passenger rechargeInBuilt(Passenger passenger, int amtToPay) {
        Passenger passengerAfterRecharge = null;
        passengerAfterRecharge = new Passenger(passenger.getMetroCardNumber(), amtToPay,
                passenger.getTripCounter());
        balanceService.updatePassenger(passengerAfterRecharge);
        return passengerAfterRecharge;
    }

    public int increaceTotalDiscount(SourceStation sourceStation, int amount) {
        int charge = Constants.ZERO;
        charge = amount / Constants.FIFTY;
        if (sourceStation.equals(SourceStation.CENTRAL)) {

            centralStation = new CentralStation(centralStation.getcentralAdultNumber(),
                    centralStation.getcentralKidNumber(),
                    centralStation.getcentralSeniorCitizenNumber(), centralStation.getcentralTotalCollection() + charge,
                    centralStation.getcentralDiscount());

        } else {
            airport = new Airport(airport.getairportAdultNumber(), airport.getairportKidNumber(),
                    airport.getairportSeniorCitizenNumber(), airport.getairportTotalCollection() + charge,
                    airport.getairportDiscount());

        }
        return charge;
    }

    public Passenger rechargeMetroCard(Passenger passenger, PassengerType passengerType, int amtToPay,
            SourceStation sourceStation) {
        int charge = Constants.ZERO;
        int leftBalance = passenger.getBalance();
        int amount = Constants.ZERO;
        Passenger passengerAfterRecharge = null;
        switch (String.valueOf(passengerType)) {
            case Constants.ADULT:
                amount = amtToPay - leftBalance;
                passengerAfterRecharge = rechargeInBuilt(passenger, amtToPay);
                break;
            case Constants.KID:
                amount = amtToPay - leftBalance;
                passengerAfterRecharge = rechargeInBuilt(passenger, amtToPay);
                break;
            case Constants.SENIOR_CITIZEN:
                amount = amtToPay - leftBalance;
                passengerAfterRecharge = rechargeInBuilt(passenger, amtToPay);
                break;
        }
        charge = increaceTotalDiscount(sourceStation, amount);
        return passengerAfterRecharge;
    }

    public int checkAmountToPay(Passenger passenger, PassengerType passengerType, SourceStation sourceStation) {
        int amountToPay = Constants.ZERO;
        if (passenger.getTripCounter() % Constants.TWO == Constants.ZERO) {
            switch (String.valueOf(passengerType)) {
                case Constants.ADULT:
                    amountToPay = PassengerFare.ADULT / Constants.TWO;
                    break;
                case Constants.KID:
                    amountToPay = PassengerFare.KID / Constants.TWO;
                    break;
                case Constants.SENIOR_CITIZEN:
                    amountToPay = PassengerFare.SENIOR_CITIZEN / Constants.TWO;
                    break;
            }

            if (sourceStation.equals(SourceStation.CENTRAL)) {

                centralStation = new CentralStation(centralStation.getcentralAdultNumber(),
                        centralStation.getcentralKidNumber(),
                        centralStation.getcentralSeniorCitizenNumber(), centralStation.getcentralTotalCollection(),
                        centralStation.getcentralDiscount() + amountToPay);

            } else {
                airport = new Airport(airport.getairportAdultNumber(), airport.getairportKidNumber(),
                        airport.getairportSeniorCitizenNumber(), airport.getairportTotalCollection(),
                        airport.getairportDiscount() + amountToPay);

            }
        } else {
            switch (String.valueOf(passengerType)) {
                case Constants.ADULT:
                    amountToPay = PassengerFare.ADULT;
                    break;
                case Constants.KID:
                    amountToPay = PassengerFare.KID;
                    break;
                case Constants.SENIOR_CITIZEN:
                    amountToPay = PassengerFare.SENIOR_CITIZEN;
                    break;
            }
        }
        return amountToPay;
    }

    public Passenger passengerCheckedIn(Passenger passenger, PassengerType passengerType, int amtToPay,
            SourceStation sourceStation) {

        Passenger passengerAfterTrip = new Passenger(passenger.getMetroCardNumber(),
                passenger.getBalance() - amtToPay,
                passenger.getTripCounter() + Constants.ONE);
        balanceService.updatePassenger(passengerAfterTrip);
        if (sourceStation.equals(SourceStation.CENTRAL)) {

            centralStation = new CentralStation(centralStation.getcentralAdultNumber(),
                    centralStation.getcentralKidNumber(),
                    centralStation.getcentralSeniorCitizenNumber(),
                    centralStation.getcentralTotalCollection() + amtToPay,
                    centralStation.getcentralDiscount());

        } else {
            airport = new Airport(airport.getairportAdultNumber(), airport.getairportKidNumber(),
                    airport.getairportSeniorCitizenNumber(), airport.getairportTotalCollection() + amtToPay,
                    airport.getairportDiscount());

        }
        return passengerAfterTrip;
    }

    @Override
    public Passenger passengerCheckedIn(HashMap<String, Passenger> passengerMap, String metroCardNumber,
            PassengerType passengerType, SourceStation sourceStation) {
        Passenger passenger = null;
        for (String i : passengerMap.keySet()) {
            if (i.equals(metroCardNumber)) {
                passenger = passengerMap.get(i);
                break;
            }
        }
        String type = String.valueOf(passengerType);
        Passenger checkedInPassenger = null;
        int amtToPay = checkAmountToPay(passenger, passengerType, sourceStation);

        switch (type) {
            case Constants.ADULT:

                if (sourceStation.equals(SourceStation.CENTRAL)) {

                    centralStation = new CentralStation(centralStation.getcentralAdultNumber() + Constants.ONE,
                            centralStation.getcentralKidNumber(),
                            centralStation.getcentralSeniorCitizenNumber(), centralStation.getcentralTotalCollection(),
                            centralStation.getcentralDiscount());

                } else {
                    airport = new Airport(airport.getairportAdultNumber() + Constants.ONE,
                            airport.getairportKidNumber(),
                            airport.getairportSeniorCitizenNumber(), airport.getairportTotalCollection(),
                            airport.getairportDiscount());

                }

                if (passenger.getBalance() >= amtToPay) {
                    checkedInPassenger = passengerCheckedIn(passenger, PassengerType.ADULT, amtToPay, sourceStation);

                } else {
                    Passenger passengerAfterRecharge = rechargeMetroCard(passenger,
                            PassengerType.ADULT, amtToPay, sourceStation);
                    checkedInPassenger = passengerCheckedIn(passengerAfterRecharge, PassengerType.ADULT,
                            amtToPay, sourceStation);

                }
                break;
            case Constants.KID:

                if (sourceStation.equals(SourceStation.CENTRAL)) {

                    centralStation = new CentralStation(centralStation.getcentralAdultNumber(),
                            centralStation.getcentralKidNumber() + Constants.ONE,
                            centralStation.getcentralSeniorCitizenNumber(), centralStation.getcentralTotalCollection(),
                            centralStation.getcentralDiscount());

                } else {
                    airport = new Airport(airport.getairportAdultNumber(),
                            airport.getairportKidNumber() + Constants.ONE,
                            airport.getairportSeniorCitizenNumber(), airport.getairportTotalCollection(),
                            airport.getairportDiscount());

                }

                if (passenger.getBalance() >= amtToPay) {
                    checkedInPassenger = passengerCheckedIn(passenger, PassengerType.KID, amtToPay, sourceStation);

                } else {
                    Passenger passengerAfterRecharge = rechargeMetroCard(passenger,
                            PassengerType.KID, amtToPay, sourceStation);
                    checkedInPassenger = passengerCheckedIn(passengerAfterRecharge, PassengerType.KID,
                            amtToPay, sourceStation);

                }
                break;
            case Constants.SENIOR_CITIZEN:

                if (sourceStation.equals(SourceStation.CENTRAL)) {

                    centralStation = new CentralStation(centralStation.getcentralAdultNumber(),
                            centralStation.getcentralKidNumber(),
                            centralStation.getcentralSeniorCitizenNumber() + Constants.ONE,
                            centralStation.getcentralTotalCollection(),
                            centralStation.getcentralDiscount());

                } else {
                    airport = new Airport(airport.getairportAdultNumber(), airport.getairportKidNumber(),
                            airport.getairportSeniorCitizenNumber() + Constants.ONE,
                            airport.getairportTotalCollection(),
                            airport.getairportDiscount());

                }

                if (passenger.getBalance() >= amtToPay) {
                    checkedInPassenger = passengerCheckedIn(passenger, PassengerType.SENIOR_CITIZEN, amtToPay,
                            sourceStation);

                } else {
                    Passenger passengerAfterRecharge = rechargeMetroCard(passenger,
                            PassengerType.SENIOR_CITIZEN, amtToPay, sourceStation);
                    checkedInPassenger = passengerCheckedIn(passengerAfterRecharge, PassengerType.SENIOR_CITIZEN,
                            amtToPay, sourceStation);

                }
                break;
        }
        // System.err.println(checkedInPassenger);
        return checkedInPassenger;
    }

    @Override
    public String printSummaryOfPassengers() {
        String output = "";
        output += "TOTAL_COLLECTION CENTRAL " + centralStation.getcentralTotalCollection() + " "
                + centralStation.getcentralDiscount()
                + "\n";
        output += "PASSENGER_TYPE_SUMMARY\n";

        if (centralStation.getcentralAdultNumber() != Constants.ZERO) {
            output += Constants.ADULT + " " + centralStation.getcentralAdultNumber() + "\n";
        }
        if (centralStation.getcentralKidNumber() != Constants.ZERO) {
            output += Constants.KID + " " + centralStation.getcentralKidNumber() + "\n";
        }
        if (centralStation.getcentralSeniorCitizenNumber() != Constants.ZERO) {
            output += Constants.SENIOR_CITIZEN + " " + centralStation.getcentralSeniorCitizenNumber() + "\n";
        }

        output += "TOTAL_COLLECTION AIRPORT " + airport.getairportTotalCollection() + " " + airport.getairportDiscount()
                + "\n";
        output += "PASSENGER_TYPE_SUMMARY\n";
        if (airport.getairportAdultNumber() != Constants.ZERO) {
            output += Constants.ADULT + " " + airport.getairportAdultNumber() + "\n";
        }
        if (airport.getairportKidNumber() != Constants.ZERO) {
            output += Constants.KID + " " + airport.getairportKidNumber() + "\n";
        }
        if (airport.getairportSeniorCitizenNumber() != Constants.ZERO) {
            output += Constants.SENIOR_CITIZEN + " " + airport.getairportSeniorCitizenNumber() + "\n";
        }
        System.out.println(output);
        return output;
    }
}
