package com.madest.command;

import com.madest.apprunner.AppRunner;
import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Coordinates;
import com.madest.dragon.Dragon;
import com.madest.dragon.DragonHead;
import com.madest.dragon.DragonType;
import com.madest.server.Server;

import java.util.Scanner;
import java.util.Set;

public class FilterByHeadCommand implements Command,ReturningCommand {
    private Server server;

    public FilterByHeadCommand(Server server) {
        this.server = server;
    }

    @Override
    public void doCommand(DragonSetHolder dragonsSet) {

        String argument = server.getArgument();
        if (!(argument.contains("f")) && Character.isDigit(argument.toCharArray()[0])) {
            System.out.println(argument);
            float eyesCount = Float.parseFloat(argument);
            dragonsSet.stream().filter(dragon -> dragon.getHead().getEyesCount() == eyesCount).forEach(System.out::println);
            if (dragonsSet.stream().filter(dragon -> dragon.getHead().getEyesCount() == eyesCount).count() == 0) {
                System.out.println("Не найдено дракона с таким количеством глаз");
            }
        } else {
            System.out.println("Не введён аргумент команды");
        }


    }

    public String doCommand(DragonSetHolder dragonsSet,boolean returnResponse) {
        StringBuilder response = new StringBuilder();
        if (returnResponse) {
            String argument = server.getArgument();
            if (!(argument.contains("f")) && Character.isDigit(argument.toCharArray()[0])) {
                System.out.println(argument);
                float eyesCount = Float.parseFloat(argument);
                dragonsSet.stream().filter(dragon -> dragon.getHead().getEyesCount() == eyesCount).forEach(dragon -> response.append(dragon).append(" "));
                if (dragonsSet.stream().filter(dragon -> dragon.getHead().getEyesCount() == eyesCount).count() == 0) {
                    return "Не найдено дракона с таким количеством глаз";
                }
            } else {
                return "Не введён аргумент команды";
            }
        }
        return response.toString();
    }
}
