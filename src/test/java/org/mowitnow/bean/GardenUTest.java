package org.mowitnow.bean;


import org.junit.Assert;
import org.junit.Test;

public class GardenUTest {

    private Garden garden;

    @Test(expected = IllegalArgumentException.class)
    public void constructor_withWrongXMax_shouldThrowIAException() {
        // Given
        int xMax = 0;
        int yMax = 5;

        // When
        garden = new Garden(xMax, yMax);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_withWrongYMax_shouldThrowIAException() {
        // Given
        int xMax = 5;
        int yMax = -5;

        // When
        garden = new Garden(xMax, yMax);
    }

}
