package com.madest.apprunner;

import java.io.File;
import java.nio.file.Path;

public class FileHolder {

    private Path path;

    public FileHolder(String[] args) {
        path = Path.of("src","Dragons",args.length != 0 ? args[0] : AppRunner.getFilename());
    }

    public FileHolder(String arg) {
        path = Path.of("src","Dragons",arg);
    }


    public Path getPath() {
        return path;
    }

    public File getFile() {
        return path.toFile();
    }
}
