package com.madest.server;

import com.madest.apprunner.DragonSetHolder;
import com.madest.apprunner.ExtraSaver;
import com.madest.apprunner.FileHolder;
import com.madest.command.Command;
import com.madest.command.Commands;
import com.madest.command.ReturningCommand;
import com.madest.dragon.Dragon;
import com.madest.exceptions.ServerCreationException;

import java.io.*;
import java.net.ServerSocket;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private int port;
    private String fileName;
    private String[] commandArguments;
    private boolean stopped;
    private List<String> commandsUsed;
    private String argument;
    private LocalDateTime localDateTime;


    public Server(int port,String fileName) {
        this.port = port;
        this.fileName = fileName;
        commandsUsed = new ArrayList<>();

    }

    public void run() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {

                runClientWork(server);
            } catch (IOException e) {
                System.out.println("");
            }
        }
    }

    private void runClientWork(ServerSocket server) throws IOException {
        while (true) {
            var clientConnection = server.accept();

            try (var inputStream = new DataInputStream(clientConnection.getInputStream());
                 var outputStream = new DataOutputStream(clientConnection.getOutputStream())) {
                FileHolder fileHolder = new FileHolder(fileName);
                DragonSetHolder dragonSet = new DragonSetHolder();
                fillDragonsSet(fileHolder, dragonSet);


                while (!stopped) {
                    var commandWithArgs = inputStream.readUTF();

                    commandArguments = commandWithArgs.split(" ");
                    Commands commands = new Commands(this);
                    String command = commandArguments[0];
                    argument = commandArguments[commandArguments.length - 1];
                    if (commands.containsCommand(command)) {
                        if (command.equals("exit")) {

                            ExtraSaver.extraSaveCollection(dragonSet);
                            break;
                        }
                        commandsUsed.add(command);
                        ReturningCommand command1 = (ReturningCommand) commands.getCommand(command);
                        var s = command1.doCommand(dragonSet, true);
                        outputStream.writeUTF(s);

                    }
                }


            }
        }
    }


    private static void fillDragonsSet(FileHolder fileHolder, DragonSetHolder dragonSet) {
        Path path = fileHolder.getPath();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))){
            Object readObject;
            while ((readObject = objectInputStream.readObject()) != null){
                dragonSet.add((Dragon) readObject);
            }
            System.out.println("Драконы из файлы считаны успешно,можете приступить к вводу команд\nСписок всех доступных команд : help");
        } catch (EOFException ignored) {
        } catch (FileNotFoundException e) {
            System.out.println("Путь к файлу указан неверно , введите повторно имя файла");

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getCommandsUsed() {
        return commandsUsed;
    }

    public String getArgument() {
        return argument;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String[] getCommandArguments() {
        return commandArguments;
    }
}
