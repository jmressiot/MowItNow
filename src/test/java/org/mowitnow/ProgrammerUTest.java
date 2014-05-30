package org.mowitnow;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.mowitnow.bean.Mower;
import org.mowitnow.bean.Orientation;
import org.mowitnow.bean.Position;
import org.mowitnow.exception.ParserFileException;

import java.util.List;

public class ProgrammerUTest {

    private Programmer programmer;


    @Test
    public void execute_withNominalCase_shouldReturnExpectedPositions() throws Exception {
        // Given
        List<String> lines = Lists.newArrayList(
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        );
        programmer = new Programmer(lines);

        // When
        programmer.execute();

        // Then
        List<Mower> mowers = programmer.getMowers();

        Assert.assertEquals(new Position(1, 3, Orientation.N), mowers.get(0).getPosition());
        Assert.assertEquals(new Position(5, 1, Orientation.E), mowers.get(1).getPosition());

    }


    @Test
    public void execute_withNoLine_shouldThrowParserFileExceptionWithExpectedMessage() {
        // Given
        List<String> lines = null;
        String expectedErrorMessage = "Error when reading file: no line in file";
        String errorMessage = null;


        programmer = new Programmer(lines);

        // When
        try {
            programmer.execute();
        } catch (ParserFileException e) {
            errorMessage = e.getMessage();
        }

        // Then
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }


    @Test
    public void execute_withEvenNumberLines_shouldThrowParserFileExceptionWithExpectedMessage() {
        // Given
        List<String> lines = Lists.newArrayList(
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E"
        );
        String expectedErrorMessage = "Error when reading file: the numbers of lines is incorrect";
        String errorMessage = null;


        programmer = new Programmer(lines);

        // When
        try {
            programmer.execute();
        } catch (ParserFileException e) {
            errorMessage = e.getMessage();
        }

        // Then
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }

    @Test
    public void execute_withNotEnoughLines_shouldThrowParserFileExceptionWithExpectedMessage() {
        // Given
        List<String> lines = Lists.newArrayList(
                "5 5",
                "1 2 N"
        );
        String expectedErrorMessage = "Error when reading file: the numbers of lines is incorrect";
        String errorMessage = null;


        programmer = new Programmer(lines);

        // When
        try {
            programmer.execute();
        } catch (ParserFileException e) {
            errorMessage = e.getMessage();
        }

        // Then
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }


    @Test
    public void execute_withErrorOnGardenLine_shouldThrowParserFileExceptionWithExpectedMessage() {
        // Given
        String gardenLine = "5 5 5";
        List<String> lines = Lists.newArrayList(
                gardenLine,
                "1 2 N",
                "AADAADADDA"
        );
        String expectedErrorMessage = "Error when parsing file on line: " + gardenLine;
        String errorMessage = null;


        programmer = new Programmer(lines);

        // When
        try {
            programmer.execute();
        } catch (ParserFileException e) {
            errorMessage = e.getMessage();
        }

        // Then
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }

    @Test
    public void execute_withErrorOnPositionLine_shouldThrowParserFileExceptionWithExpectedMessage() {
        // Given
        String positionLine = "1 4 Y";
        List<String> lines = Lists.newArrayList(
                "5 5",
                positionLine,
                "AADAADADDA"
        );
        String expectedErrorMessage = "Error when parsing file on line: " + positionLine;
        String errorMessage = null;


        programmer = new Programmer(lines);

        // When
        try {
            programmer.execute();
        } catch (ParserFileException e) {
            errorMessage = e.getMessage();
        }

        // Then
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }

    @Test
    public void execute_withErrorOnOrdersLine_shouldThrowParserFileExceptionWithExpectedMessage() {
        // Given
        String ordersLine = "AAADAAGGAAN";
        List<String> lines = Lists.newArrayList(
                "5 5",
                "1 2 N",
                ordersLine
        );
        String expectedErrorMessage = "Error when parsing file on line: " + ordersLine;
        String errorMessage = null;


        programmer = new Programmer(lines);

        // When
        try {
            programmer.execute();
        } catch (ParserFileException e) {
            errorMessage = e.getMessage();
        }

        // Then
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }
}
