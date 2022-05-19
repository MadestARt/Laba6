package com.madest.command;

import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Dragon;

import java.util.Set;

public class PrintDescendingCommand implements Command,ReturningCommand{
    @Override
    public void doCommand(DragonSetHolder dragonsSet) {
        Object[] objects = dragonsSet.stream().sorted().toArray();
        for (int i = objects.length - 1;i > -1;i--) {
            System.out.println(objects[i]);
        }
        System.out.println();
    }

        public String doCommand(DragonSetHolder dragonsSet,boolean returnResponse) {
        StringBuilder response = new StringBuilder();
        if (returnResponse) {
            dragonsSet.stream().sorted().forEach(response::append);
        }
        return response.toString();
    }
}
