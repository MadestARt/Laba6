package com.madest.command;

import com.madest.apprunner.AppRunner;
import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Dragon;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;

public class SaveCollectionCommand implements Command,ReturningCommand{

    @Override
    public void doCommand(DragonSetHolder dragonsSet) {
            System.out.println("Введите имя и расширение файла , куда вы хотите сохранить драконо\nФайл сохранится в папку \"SavedCollections\"");
            String fileName = new Scanner(System.in).nextLine();
            Path path = Path.of("src", "SavedCollections","savedByUserCollections" ,fileName);
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
                objectOutputStream.writeObject(dragonsSet.getDragonSet());
                System.out.println("Коллекция успешно сохранена в файл " + path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

        public String doCommand(DragonSetHolder dragonsSet,boolean returnResponse) {
        String response = "";
        if (returnResponse) {
            System.out.println("Введите имя и расширение файла , куда вы хотите сохранить драконо\nФайл сохранится в папку \"SavedCollections\"");
            String fileName = new Scanner(System.in).nextLine();
            Path path = Path.of("src", "SavedCollections","savedByUserCollections" ,fileName);
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
                objectOutputStream.writeObject(dragonsSet.getDragonSet());
                return "Коллекция успешно сохранена в файл " + path.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}
