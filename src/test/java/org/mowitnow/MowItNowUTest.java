package org.mowitnow;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by home on 25/05/2014.
 */
public class MowItNowUTest {

    @Test
    public void main_withFileInParams_shouldReturnNoError() {
        // Given
        boolean hasError = false;
        String[] args = new String[1];
        args[0] = "input.txt";

        // When
        try {
            MowItNow.main(args);
        } catch (Exception e) {
            hasError = true;
        }

        // Then
        Assert.assertFalse(hasError);
    }
}
