package org.mowitnow;

import org.mowitnow.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.List;

/**
 * Created by home on 25/05/2014.
 */
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

