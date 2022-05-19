package com.madest.command;

import com.madest.apprunner.DragonSetHolder;

public class PrintUpperCommand implements Command,ReturningCommand{

    @Override
    public void doCommand(DragonSetHolder dragonsSet) {
        dragonsSet.stream().sorted((d1,d2) -> d1.getAge() > d2.getAge() ? 1 : -1).forEach(System.out::println);
    }

        public String doCommand(DragonSetHolder dragonsSet,boolean returnResponse) {
        StringBuilder response = new StringBuilder();
        if (returnResponse) {
            dragonsSet.stream().sorted((d1,d2) -> d1.getAge() > d2.getAge() ? 1 : -1).forEach(response::append);
        }
        return response.toString();
    }
}
