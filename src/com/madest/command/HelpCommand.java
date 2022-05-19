package com.madest.command;

import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Dragon;
import com.madest.server.Server;

import java.util.Map;
import java.util.Set;

public class HelpCommand implements Command,ReturningCommand {

    @Override
    public void doCommand(DragonSetHolder dragonSet) {
            Set<Map.Entry<String, String>> entries = new Commands(new Server(12,"asd")).getDescriptionCommandsMap().entrySet();
            for (Map.Entry<String,String> entry : entries) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
    }

    public String doCommand(DragonSetHolder dragonsSet,boolean returnResponse) {
        StringBuilder response = new StringBuilder();
        if (returnResponse) {
            Set<Map.Entry<String, String>> entries = new Commands(new Server(12,"asd")).getDescriptionCommandsMap().entrySet();

            entries.forEach(entry -> response.append(entry.getKey()).append(" ").append(entry.getValue()));
        }
        return response.toString();
    }
}
