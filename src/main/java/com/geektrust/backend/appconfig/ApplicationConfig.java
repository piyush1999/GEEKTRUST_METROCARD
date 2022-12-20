package com.geektrust.backend.appconfig;

import java.util.HashMap;

import com.geektrust.backend.commands.CheckinCommand;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.commands.CreatePassengerCommand;
import com.geektrust.backend.commands.PrintSummaryCommand;
import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.entities.Airport;
import com.geektrust.backend.entities.CentralStation;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.services.BalanceService;
import com.geektrust.backend.services.BalanceServiceImpl;
import com.geektrust.backend.services.CheckInService;
import com.geektrust.backend.services.CheckInServiceImpl;

public class ApplicationConfig {

    private final Airport airport = new Airport(Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO);
    private final CentralStation centralStation = new CentralStation(Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO);
    private final BalanceService balanceService = new BalanceServiceImpl();
    private final CheckInService checkInService = new CheckInServiceImpl(balanceService, airport, centralStation);
    private final CommandInvoker commandInvoker = new CommandInvoker();

    private final CreatePassengerCommand createPassengerCommand = new CreatePassengerCommand(balanceService);
    private final CheckinCommand checkinCommand = new CheckinCommand(checkInService, balanceService);
    private final PrintSummaryCommand printSummaryCommand = new PrintSummaryCommand(checkInService);

    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("BALANCE", createPassengerCommand);
        commandInvoker.register("CHECK_IN", checkinCommand);
        commandInvoker.register("PRINT_SUMMARY", printSummaryCommand);
        return commandInvoker;
    }

}
