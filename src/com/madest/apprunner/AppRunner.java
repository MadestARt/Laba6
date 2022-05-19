package com.madest.apprunner;

import com.madest.command.Commands;
import com.madest.command.SaveCollectionCommand;
import com.madest.dragon.Dragon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;


// класс,который сохраняет коллекцию

public class AppRunner {

    private static String[] commandArguments;
    private static LocalDateTime ldt;
    private static List<String> commandsUsed = new ArrayList<>();
    private static final Scanner scan = new Scanner(System.in);
    public static String argument;
    public static Set<String> executedScripts;
    // имя файла в args
    public static void main(String[] args) {

//        executedScripts = new HashSet<>();
//        Commands commands = new Commands();
//        FileHolder fileHolder = new FileHolder(args);
//        DragonSetHolder dragonSet = new DragonSetHolder();
//
//        ldt = LocalDateTime.now();
//        fillDragonsSet(fileHolder, dragonSet);
//        System.out.println("Драконы из файлы считаны успешно,можете приступить к вводу команд\nСписок всех доступных команд : help");
//
//
//        while (true) {
//            commandArguments = scan.nextLine().split(" ");
//            String command = commandArguments[0];
//            argument = commandArguments[commandArguments.length - 1];
//            if (commands.containsCommand(command)) {
//                if (command.equals("exit")) {
//
//                    ExtraSaver.extraSaveCollection(dragonSet);
//                    break;
//                }
//                commandsUsed.add(command);
//                commands.getCommand(command).doCommand(dragonSet);
//            } else {
//                System.out.println("Такой команды нет , вывести список всех доступных комманд : help");
//            }
//
//        }

    }

    public static String[] getCommandArguments() {
        return commandArguments;
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
            String newFileName = scan.nextLine();
            FileHolder newFileHolder = new FileHolder(newFileName);
            fillDragonsSet(newFileHolder, dragonSet);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getCommandsUsed() {
        return commandsUsed;
    }

    public static String getFilename() {
        System.out.println("Введите имя файла из папки src/Dragons");
        return scan.nextLine();
    }

    public static String getArgument() {
        return argument;
    }


    public static LocalDateTime getLdt() {
        return ldt;
    }
}
