package org.mowitnow;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class MowItNowUTest {

    private ByteArrayOutputStream outputStream;

    @Before
    public void init() {

        // init logger
        Logger logger = Logger.getRootLogger();
        PatternLayout patternLayout = new PatternLayout("%m%n");

        outputStream = new ByteArrayOutputStream();
        logger.addAppender(new WriterAppender(patternLayout,
                outputStream));
        logger.setLevel(Level.INFO);
    }

    @Test
    public void main_withFileInParams_shouldReturnExpectedResults() {
        // Given
        String[] args = new String[]{"input.txt"};
        String expectedPositionMower1 = "1 3 N";
        String expectedPositionMower2 = "5 1 E";

        // When
        MowItNow.main(args);

        // Then
        String[] logs = getLogs();
        Assert.assertNotNull(logs);
        Assert.assertEquals(2, logs.length);
        Assert.assertEquals(expectedPositionMower1, logs[0]);
        Assert.assertEquals(expectedPositionMower2, logs[1]);
    }


    @Test
    public void main_withNullArg_shouldLogExpectedErrorMessage() {
        // Given
        String expectedErrorMessage = "Please provide a file in argument";

        // When
        MowItNow.main(null);

        // Then
        String[] logs = getLogs();
        Assert.assertNotNull(logs);
        Assert.assertEquals(expectedErrorMessage, logs[0]);
    }

    @Test
    public void main_withEmptyArg_shouldLogExpectedErrorMessage() {
        // Given
        String[] args = new String[]{"nowhere"};
        String expectedErrorMessage = "Exception when reading file. Please check your file in argument.";

        // When
        MowItNow.main(args);

        // Then
        String[] logs = getLogs();
        Assert.assertNotNull(logs);
        Assert.assertEquals(logs[0], expectedErrorMessage);
    }

    @Test
    public void main_withFileInError_shouldLogExpectedErrorMessage() throws Exception {
        // Given
        String[] args = new String[]{"input_with_error.txt"};
        String expectedErrorMessage = "Please check the following line: AAEEEZZ";

        // When
        MowItNow.main(args);

        // Then
        String[] logs = getLogs();
        Assert.assertNotNull(logs);
        Assert.assertEquals(expectedErrorMessage, logs[0]);
    }


    private String[] getLogs() {
        return new String(outputStream.toByteArray()).split("\n");
    }

}
