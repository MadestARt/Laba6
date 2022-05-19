package com.madest.command;

import com.madest.apprunner.AppRunner;
import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Dragon;
import com.madest.server.Server;

import java.util.Set;

public class RemoveLowerCommand implements Command,ReturningCommand{
    private Server server;

    public RemoveLowerCommand(Server server) {
        this.server = server;
    }

    @Override
    public void doCommand(DragonSetHolder dragonsSet) {
        Long minAge = Long.parseLong(server.getCommandArguments()[1]);
        dragonsSet.getDragonSet().removeIf(dragon -> dragon.getAge() < minAge);
    }


    public String doCommand(DragonSetHolder dragonsSet,boolean returnResponse) {
        String response = "";
        if (returnResponse) {
            Long minAge = Long.parseLong(server.getCommandArguments()[1]);
            dragonsSet.getDragonSet().removeIf(dragon -> dragon.getAge() < minAge);
            return "Успешно удалён элемент";
        }
        return response;
    }
}
