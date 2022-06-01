package com.madest.command;

import com.madest.apprunner.DragonSetHolder;
import com.madest.server.Server;

public class HistoryCommand implements Command,ReturningCommand{
    @Override
    public void doCommand(DragonSetHolder dragonsSet) {

    }

    @Override
    public String doCommand(DragonSetHolder dragonsSet, boolean returnResponse) {
        return Server.getCommandsUsed().toString();
    }
}
