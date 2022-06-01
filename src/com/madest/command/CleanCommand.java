package com.madest.command;

import com.madest.apprunner.DragonSetHolder;

public class CleanCommand implements Command,ReturningCommand{

    @Override
    public void doCommand(DragonSetHolder dragonsSet) {

    }

    @Override
    public String doCommand(DragonSetHolder dragonsSet, boolean returnResponse) {
        dragonsSet.clear();
        return "Коллекция очищена";

    }
}
