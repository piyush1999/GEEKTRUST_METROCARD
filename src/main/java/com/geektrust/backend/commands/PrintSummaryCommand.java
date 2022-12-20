package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.services.CheckInService;

public class PrintSummaryCommand implements ICommand {

    private final CheckInService checkInService;

    public PrintSummaryCommand(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @Override
    public void execute(List<String> tokens) {
        checkInService.printSummaryOfPassengers();
    }

}
