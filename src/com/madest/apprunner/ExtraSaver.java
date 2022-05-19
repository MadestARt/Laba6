package com.madest.apprunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class ExtraSaver {


    private static Path closedCollectionsPath = Path.of("src","SavedCollections","extraClosedCollections","lastClosedCollection.csv");

    public static void extraSaveCollection(DragonSetHolder dragonSetHolder) {
        if (!AppRunner.getCommandsUsed().contains("save")) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(closedCollectionsPath.toFile()))) {
                objectOutputStream.writeObject(dragonSetHolder.getDragonSet());

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Ваша коллекция автоматически сохранилась в папке SavedCollections/extraClosedCollections");
        }
    }
}

