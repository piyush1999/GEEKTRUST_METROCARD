package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.services.BalanceService;

public class CreatePassengerCommand implements ICommand {

    private final BalanceService balanceService;

    public CreatePassengerCommand(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @Override
    public void execute(List<String> tokens) {
        if (tokens.size() == Constants.THREE) {
            String metroCardNumber = tokens.get(Constants.ONE);
            int balance = Integer.parseInt(tokens.get(Constants.TWO));
            Passenger passenger = balanceService.createPassenger(metroCardNumber, balance);
        }
    }
}
