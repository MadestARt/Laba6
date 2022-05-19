package com.madest.command;

import com.madest.apprunner.AppRunner;
import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Coordinates;
import com.madest.dragon.Dragon;
import com.madest.dragon.DragonHead;
import com.madest.dragon.DragonType;
import com.madest.server.Server;

import java.util.Set;

public class UpdateIdCommand implements Command,ReturningCommand{

    private Server server;

    public UpdateIdCommand(Server server) {
        this.server = server;
    }

    @Override
    public void doCommand(DragonSetHolder dragonsSet) {
        try {
            String[] arguments = server.getCommandArguments();
            int id = Integer.parseInt(arguments[1]);
            String name = arguments[2];
            double xCor = Double.parseDouble(arguments[3]);
            float yCor = Float.parseFloat(arguments[4]),wingspan = Float.parseFloat(arguments[6]),eyesCount = Float.parseFloat(arguments[8]);
            long age = Long.parseLong(arguments[5]);
            DragonType dragonType = DragonType.valueOf(arguments[7]);
            dragonsSet.getDragonSet().removeIf(dragon -> dragon.getId() == id);
            Dragon dragon = new Dragon(name, new Coordinates(xCor, yCor), age, wingspan, dragonType, new DragonHead(eyesCount));
            dragon.setId(id);
            dragonsSet.add(dragon);
        } catch (RuntimeException e) {
            System.out.println("Введены не все аргументы для добавления дракона\nФормат ввода : имя координатаХ координатаУ возраст размах крыльев ТИП количествоГлаз (Всё через пробел)");
        }
    }

        public String doCommand(DragonSetHolder dragonsSet,boolean returnResponse) {
        String response = "";
        if (returnResponse) {
            try {
                String[] arguments = server.getCommandArguments();
                int id = Integer.parseInt(arguments[1]);
                String name = arguments[2];
                double xCor = Double.parseDouble(arguments[3]);
                float yCor = Float.parseFloat(arguments[4]),wingspan = Float.parseFloat(arguments[6]),eyesCount = Float.parseFloat(arguments[8]);
                long age = Long.parseLong(arguments[5]);
                DragonType dragonType = DragonType.valueOf(arguments[7]);
                dragonsSet.getDragonSet().removeIf(dragon -> dragon.getId() == id);
                Dragon dragon = new Dragon(name, new Coordinates(xCor, yCor), age, wingspan, dragonType, new DragonHead(eyesCount));
                dragon.setId(id);
                dragonsSet.add(dragon);
                return "Успешно добавлен дракон";
            } catch (RuntimeException e) {
                return "Введены не все аргументы для добавления дракона\nФормат ввода : имя координатаХ координатаУ возраст размах крыльев ТИП количествоГлаз (Всё через пробел)";
            }
        }
        return response;
    }
}
