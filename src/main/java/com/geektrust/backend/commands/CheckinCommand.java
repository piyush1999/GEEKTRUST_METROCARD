package com.geektrust.backend.commands;

import java.util.HashMap;
import java.util.List;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.entities.SourceStation;
import com.geektrust.backend.services.BalanceService;
import com.geektrust.backend.services.CheckInService;

public class CheckinCommand implements ICommand {

    private final CheckInService checkInService;
    private final BalanceService balanceService;

    public CheckinCommand(CheckInService checkInService, BalanceService balanceService) {
        this.checkInService = checkInService;
        this.balanceService = balanceService;
    }

    @Override
    public void execute(List<String> tokens) {
        if (tokens.size() == Constants.FOUR) {
            String metroCard = tokens.get(Constants.ONE);
            PassengerType passengerType = PassengerType.valueOf(tokens.get(Constants.TWO));
            SourceStation sourceStation = SourceStation.valueOf(tokens.get(Constants.THREE));
            HashMap<String, Passenger> passengerMap = balanceService.getAll();
            checkInService.passengerCheckedIn(passengerMap, metroCard, passengerType, sourceStation);
        }
    }
}
