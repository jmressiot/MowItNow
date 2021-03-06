package org.mowitnow.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class FileUtils {

    private FileUtils() {
    }

    /**
     * Read the file
     */
    public static List<String> readFile(File file) throws IOException {
        if (file == null) {
            return null;
        }
        return Files.readAllLines(Paths.get(file.getAbsolutePath()), Charset.defaultCharset());
    }

}
