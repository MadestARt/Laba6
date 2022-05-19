package com.madest.command;

import com.madest.apprunner.AppRunner;
import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Coordinates;
import com.madest.dragon.Dragon;
import com.madest.dragon.DragonHead;
import com.madest.dragon.DragonType;
import com.madest.server.Server;

import java.util.Comparator;
import java.util.Set;

public class AddIfMinCommand implements Command,ReturningCommand{
    private Server server;

    public AddIfMinCommand(Server server) {
        this.server = server;
    }

    @Override
    public void doCommand(DragonSetHolder dragonsSet) {
        try {
            if (Long.parseLong(server.getCommandArguments()[4]) < dragonsSet.getDragonSet().stream().min(Comparator.comparingLong(Dragon::getAge)).map(Dragon::getAge).get()) {

                String[] arguments = server.getCommandArguments();
                String name = arguments[1];
                double xCor = Double.parseDouble(arguments[2]);
                float yCor = Float.parseFloat(arguments[3]),wingspan = Float.parseFloat(arguments[5]),eyesCount = Float.parseFloat(arguments[7]);
                long age = Long.parseLong(arguments[4]);
                DragonType dragonType = DragonType.valueOf(arguments[6]);


                Dragon dragonToAdd = new Dragon(name,new Coordinates(xCor,yCor),age,wingspan,dragonType,new DragonHead(eyesCount));
                dragonsSet.add(dragonToAdd);
                System.out.println("Дракон добавлен");


            } else {
                System.out.println("Дракон не является наименьшим");
            }
        } catch (RuntimeException e) {
            System.out.println("Введены не все аргументы для добавления дракона\nФормат ввода : имя координатаХ координатаУ возраст размах крыльев ТИП количествоГлаз (Всё через пробел)");
        }
    }

    public String doCommand(DragonSetHolder dragonsSet,boolean returnResponse) {
        String response = "";
        if (returnResponse) {
            try {
                if (Long.parseLong(server.getCommandArguments()[4]) < dragonsSet.getDragonSet().stream().min(Comparator.comparingLong(Dragon::getAge)).map(Dragon::getAge).get()) {

                    String[] arguments = server.getCommandArguments();
                    String name = arguments[1];
                    double xCor = Double.parseDouble(arguments[2]);
                    float yCor = Float.parseFloat(arguments[3]),wingspan = Float.parseFloat(arguments[5]),eyesCount = Float.parseFloat(arguments[7]);
                    long age = Long.parseLong(arguments[4]);
                    DragonType dragonType = DragonType.valueOf(arguments[6]);


                    Dragon dragonToAdd = new Dragon(name,new Coordinates(xCor,yCor),age,wingspan,dragonType,new DragonHead(eyesCount));
                    dragonsSet.add(dragonToAdd);
                    return "Дракон добавлен";


                } else {
                    return "Дракон не является наименьшим";
                }
            } catch (RuntimeException e) {
                return "Введены не все аргументы для добавления дракона\nФормат ввода : имя координатаХ координатаУ возраст размах крыльев ТИП количествоГлаз (Всё через пробел)";
            }
        }
        return response;
    }
}
