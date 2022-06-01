package com.madest.command;

import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Dragon;
import com.madest.server.Server;

import java.util.Set;
import java.util.stream.Collectors;

public class RemoveByIdCommand implements Command,ReturningCommand{
    @Override
    public void doCommand(DragonSetHolder dragonsSet) {

    }

    @Override
    public String doCommand(DragonSetHolder dragonsSet, boolean returnResponse) {
        var argument = Server.getArgument();
        var dragonSet = dragonsSet.stream().filter(dragon -> dragon.getId() != Integer.parseInt(argument))
                .collect(Collectors.toSet());
        dragonsSet.setNewDragonSet(dragonSet);
        return "Дракон с данным id удалён из коллекции";
    }
}
