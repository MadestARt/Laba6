package com.madest.command;

import com.madest.apprunner.DragonSetHolder;
import com.madest.server.Server;

public class InfoCommand implements Command,ReturningCommand{
    @Override
    public void doCommand(DragonSetHolder dragonsSet) {

    }

    @Override
    public String doCommand(DragonSetHolder dragonsSet, boolean returnResponse) {
        return "Коллекция драконов. Тип коллекции:Set Дата инициализации " + Server.getInitDateTime() + " размер коллекции " + dragonsSet.size();
    }
}
