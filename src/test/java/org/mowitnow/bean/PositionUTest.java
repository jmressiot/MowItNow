package org.mowitnow.bean;

import org.junit.Assert;
import org.junit.Test;

public class PositionUTest {

    private Position position;

    @Test
    public void moveToRight_shouldReturnExpectedPosition() {
        // Given
        position = new Position(5, 5, Orientation.N);
        Position expectedPosition = new Position(5, 5, Orientation.E);


        // When
        position.moveToRight();

        // Then
        Assert.assertEquals(expectedPosition, position);
    }

    @Test
    public void moveToLeft_shouldReturnExpectedPosition() {
        // Given
        position = new Position(5, 5, Orientation.N);
        Position expectedPosition = new Position(5, 5, Orientation.W);

        // When
        position.moveToLeft();

        // Then
        Assert.assertEquals(expectedPosition, position);
    }

    @Test
    public void moveForward_withOrientationNorth_shouldReturnExpectedPosition() {
        // Given
        Garden garden = new Garden(5, 5);
        position = new Position(0, 0, Orientation.N);
        Position expectedPosition = new Position(0, 1, Orientation.N);

        // When
        position.moveForward(garden);

        // Then
        Assert.assertEquals(expectedPosition, position);
    }


    @Test
    public void moveForward_withOrientationWest_shouldReturnExpectedPosition() {
        // Given
        Garden garden = new Garden(5, 5);
        position = new Position(1, 1, Orientation.W);
        Position expectedPosition = new Position(0, 1, Orientation.W);

        // When
        position.moveForward(garden);

        // Then
        Assert.assertEquals(expectedPosition, position);
    }


    @Test
    public void moveForward_withOrientationEast_shouldReturnExpectedPosition() {
        // Given
        Garden garden = new Garden(5, 5);
        position = new Position(1, 1, Orientation.E);
        Position expectedPosition = new Position(2, 1, Orientation.E);

        // When
        position.moveForward(garden);

        // Then
        Assert.assertEquals(expectedPosition, position);
    }

    @Test
    public void moveForward_withOrientationSouth_shouldReturnExpectedPosition() {
        // Given
        Garden garden = new Garden(5, 5);
        position = new Position(1, 1, Orientation.S);
        Position expectedPosition = new Position(1, 0, Orientation.S);

        // When
        position.moveForward(garden);

        // Then
        Assert.assertEquals(expectedPosition, position);
    }

    @Test
    public void moveForward_beyondGarden_shouldReturnSamePosition() {
        // Given
        Garden garden = new Garden(5, 5);

        // with North
        Position positionN = new Position(5, 5, Orientation.N);
        Position expectedPositionN = new Position(5, 5, Orientation.N);

        // with West
        Position positionW = new Position(0, 5, Orientation.W);
        Position expectedPositionW = new Position(0, 5, Orientation.W);

        // with East
        Position positionE = new Position(5, 5, Orientation.E);
        Position expectedPositionE = new Position(5, 5, Orientation.E);

        // with South
        Position positionS = new Position(5, 0, Orientation.S);
        Position expectedPositionS = new Position(5, 0, Orientation.S);


        // When
        positionN.moveForward(garden);
        positionW.moveForward(garden);
        positionE.moveForward(garden);
        positionS.moveForward(garden);

        // Then
        Assert.assertEquals(expectedPositionN, positionN);
        Assert.assertEquals(expectedPositionW, positionW);
        Assert.assertEquals(expectedPositionE, positionE);
        Assert.assertEquals(expectedPositionS, positionS);
    }


    @Test(expected = IllegalArgumentException.class)
    public void constructor_WithNegativeX_shouldThrowIAException() {
        // Given
        int x = -5;
        int y = 5;
        Orientation o = Orientation.N;

        // When
        position = new Position(x, y, o);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_WithNegativeY_shouldThrowIAException() {
        // Given
        int x = 5;
        int y = -2;
        Orientation o = Orientation.N;

// When
        position = new Position(x, y, o);
    }

    @Test(expected = NullPointerException.class)
    public void constructor_WithOrientationNull_shouldThrowNPException() {
        // Given
        int x = 5;
        int y = 5;
        Orientation o = null;

        // When
        position = new Position(x, y, o);
    }
}
