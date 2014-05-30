package org.mowitnow.bean;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MowerUTest {

    private Mower mower;

    private Garden garden;
    private Position position;
    private List<Order> orderList;

    @Before
    public void init() {
        garden = new Garden(5, 5);
        position = new Position(0, 0, Orientation.N);
        orderList = Lists.newArrayList(Order.A);

    }


    @Test
    public void move_WithOrderA_shouldMoveFoward() {
        // Given
        orderList = Lists.newArrayList(Order.A);
        mower = new Mower(garden, position, orderList);
        Position expectedPosition = position; // copy
        expectedPosition.moveForward(garden); // expected : move forward

        // When
        mower.move();

        // Then
        Assert.assertEquals(expectedPosition, mower.getPosition());
    }

    @Test
    public void move_WithOrderD_shouldMoveToRight() {
        // Given
        orderList = Lists.newArrayList(Order.D);
        mower = new Mower(garden, position, orderList);
        Position expectedPosition = position; // copy
        expectedPosition.moveToRight(); // expected : move to right

        // When
        mower.move();

        // Then
        Assert.assertEquals(expectedPosition, mower.getPosition());
    }

    @Test
    public void move_WithOrderG_shouldMoveToLeft() {
        // Given
        orderList = Lists.newArrayList(Order.G);
        mower = new Mower(garden, position, orderList);
        Position expectedPosition = position; // copy
        expectedPosition.moveToLeft(); // expected : move to left

        // When
        mower.move();

        // Then
        Assert.assertEquals(expectedPosition, mower.getPosition());
    }

    @Test(expected = NullPointerException.class)
    public void constructor_withGardenNull_shouldThrowNPException() {
        // When
        mower = new Mower(null, position, orderList);
    }


    @Test(expected = NullPointerException.class)
    public void constructor_withPositionNull_shouldThrowNPException() {
        // When
        mower = new Mower(garden, null, orderList);
    }


    @Test(expected = NullPointerException.class)
    public void constructor_withOrdersNull_shouldThrowNPException() {
        // When
        mower = new Mower(garden, position, null);
    }
}
