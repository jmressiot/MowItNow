package org.mowitnow;

import org.junit.Test;
import org.mowitnow.exception.ParserFileException;

import java.nio.file.NoSuchFileException;

public class MowItNowUTest {

    @Test
    public void main_withFileInParams_shouldReturnNoError() throws Exception {
        // Given
        String[] args = new String[]{"input.txt"};

        // When
        MowItNow.main(args);
    }


    @Test(expected = NoSuchFileException.class)
    public void main_withNullArg_shouldThrowNoSuchFileException() throws Exception {
        // Given
        String[] args = null;

        // When
        MowItNow.main(args);
    }

    @Test(expected = NoSuchFileException.class)
    public void main_withUnknownFile_shouldThrowNoSuchFileException() throws Exception {
        // Given
        String[] args = new String[]{"unknown.txt"};

        // When
        MowItNow.main(args);
    }


    @Test(expected = ParserFileException.class)
    public void main_withErrorFile_shouldThrowParserFileException() throws Exception {
        // Given
        String[] args = new String[]{"input_with_error.txt"};

        // When
        MowItNow.main(args);
    }
}
