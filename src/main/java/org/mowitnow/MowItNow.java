package org.mowitnow;

import org.mowitnow.utils.FileUtils;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class MowItNow {

    public static void main(String[] args) throws Exception {

        if (args == null || args.length == 0) {
            throw new NoSuchFileException("No argument");
        }

        List<String> lines = FileUtils.readFile(new File(args[0]));

        Programmer programmer = new Programmer(lines);
        programmer.execute();
    }
}

