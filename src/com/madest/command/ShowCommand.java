package com.madest.command;

import com.madest.apprunner.DragonSetHolder;

import java.util.stream.Collectors;

public class ShowCommand implements Command,ReturningCommand{

    @Override
    public void doCommand(DragonSetHolder dragonsSet) {

    }

    @Override
    public String doCommand(DragonSetHolder dragonsSet, boolean returnResponse) {
        return dragonsSet.toString();

    }
}
