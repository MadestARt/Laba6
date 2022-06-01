package com.madest.command;

import com.madest.apprunner.AppRunner;
import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Dragon;
import com.madest.server.Server;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Commands {

    private Map<String, Command> commandsMap;
    private Map<String,String> descriptionCommandsMap;
    private Server server;



    public Commands(Server server) {
        commandsMap = new HashMap<String, Command>(Map.of(
                "show",new ShowCommand(),
                "help",new HelpCommand(),
                "filter_by_head",new FilterByHeadCommand(server),
                "history",new HistoryCommand(),
                "remove_by_id",new RemoveByIdCommand(),
                "info",new InfoCommand(),
                "clear",new CleanCommand(),
                "print_descending",new PrintDescendingCommand(),
                "add",new AddCommand(server)
        ));
        commandsMap.put("exit",(dragonsSet -> {}));
        commandsMap.put("update",new UpdateIdCommand(server));
        commandsMap.put("save",new SaveCollectionCommand());
        commandsMap.put("add_if_min",new AddIfMinCommand(server));
        commandsMap.put("remove_lower",new RemoveLowerCommand(server));
        commandsMap.put("execute_script",new ExecuteScriptCommand(server));
        commandsMap.put("print_upper",new PrintUpperCommand());

        descriptionCommandsMap = new HashMap<>(Map.of(
                "help","вывести справку по доступным командам",
                "info"," вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)",
                "show","вывести в стандартный поток вывода все элементы коллекции в строковом представлении," ,
                "add {element}","добавить новый элемент в коллекцию",
                "update id {element}","обновить значение элемента коллекции, id которого равен заданному",
                "remove_by_id id"," удалить элемент из коллекции по его id",
                "clear","очистить коллекцию",
                "save","сохранить коллекцию в файл",
                "execute_script file_name","считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.",
                "exit","завершить программу (без сохранения в файл)"

        ));
        descriptionCommandsMap.put("add_if_min {element}","добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        descriptionCommandsMap.put("remove_lower {element}"," удалить из коллекции все элементы, меньшие, чем заданный");
        descriptionCommandsMap.put("history"," вывести последние 13 команд (без их аргументов)");
        descriptionCommandsMap.put("filter_by_head head","вывести элементы, значение поля head которых равно заданному");
        descriptionCommandsMap.put("print_descending","вывести элементы коллекции в порядке убывания");
        descriptionCommandsMap.put("print_field_descending_type","вывести значения поля type всех элементов в порядке убывания");
        descriptionCommandsMap.put("print_upper","вывести все элементы в порядке возрастания");
    }


    public boolean containsCommand(String command) {
        return commandsMap.containsKey(command);
    }

    public Command getCommand(String key) {
        return commandsMap.get(key);
    }

    public Map<String, String> getDescriptionCommandsMap() {
        return descriptionCommandsMap;
    }
}
