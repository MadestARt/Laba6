package com.madest.command;

import com.madest.apprunner.AppRunner;
import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Coordinates;
import com.madest.dragon.Dragon;
import com.madest.dragon.DragonHead;
import com.madest.dragon.DragonType;
import com.madest.server.Server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ExecuteScriptCommand implements Command,ReturningCommand{
    private String argument;
    private Server server;

    public ExecuteScriptCommand(Server server) {
        this.server = server;
    }

    @Override
    public void doCommand(DragonSetHolder dragonsSet) {
        Commands commands = new Commands(server);
        String[] commandArguments;
        String fileName = server.getCommandArguments()[1];
        if (AppRunner.executedScripts.add(fileName)) {
            Path path = Path.of("src", "Scripts", fileName);
            try {
                List<String> cmds = Files.readAllLines(path);
                for (String cmd : cmds) {
                    commandArguments = cmd.split(" ");
                    String command = commandArguments[0];

                    argument = commandArguments[commandArguments.length - 1];
                    AppRunner.argument = argument;


                    if (commands.containsCommand(command)) {
                        if (command.equals("exit")) break;
                        commands.getCommand(command).doCommand(dragonsSet);
                    } else {
                        System.out.println("Такой команды нет , вывести список всех доступных комманд : help");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String doCommand(DragonSetHolder dragonsSet,boolean returnResponse) {
        String response = "";
        if (returnResponse) {
            Commands commands = new Commands(server);
            String[] commandArguments;
            String fileName = server.getCommandArguments()[1];
            if (AppRunner.executedScripts.add(fileName)) {
                Path path = Path.of("src", "Scripts", fileName);
                try {
                    List<String> cmds = Files.readAllLines(path);
                    for (String cmd : cmds) {
                        commandArguments = cmd.split(" ");
                        String command = commandArguments[0];

                        argument = commandArguments[commandArguments.length - 1];
                        AppRunner.argument = argument;


                        if (commands.containsCommand(command)) {
                            if (command.equals("exit")) break;
                            commands.getCommand(command).doCommand(dragonsSet);
                        } else {
                            return "Такой команды нет , вывести список всех доступных комманд : help";
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }
}
