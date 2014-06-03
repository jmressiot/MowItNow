package org.mowitnow;

import org.apache.log4j.Logger;
import org.mowitnow.exception.ParserFileException;
import org.mowitnow.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class MowItNow {

    private static final Logger LOGGER = Logger.getLogger(MowItNow.class);

    private MowItNow() {
    }

    public static void main(String[] args) {

        try {
            if (args == null || args.length == 0) {
                LOGGER.error("Please provide a filename.");
                return;
            }
            List<String> lines = FileUtils.readFile(new File(args[0]));

            Programmer programmer = new Programmer(lines);
            programmer.execute();

        } catch (IOException e) {
            LOGGER.error("Exception when reading file. Please check your filename.");
        } catch (ParserFileException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

