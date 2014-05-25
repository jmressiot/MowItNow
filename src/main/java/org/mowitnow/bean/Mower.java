package org.mowitnow.bean;

import com.google.common.base.Preconditions;

import java.util.List;

/**
 * Created by home on 09/05/2014.
 */
public class Mower {

    private Garden garden;
    private Position position;
    private List<Order> orders;

    public Mower(Garden garden, Position position, List<Order> orders) {
        this.garden = Preconditions.checkNotNull(garden);
        this.position = Preconditions.checkNotNull(position);
        this.orders = Preconditions.checkNotNull(orders);
    }

    public void move() {
        for (Order order : orders) {
            move(order);
        }
    }

    private void move(Order order) {
        switch (order) {
            case D:
                position.moveToRight();
                break;
            case G:
                position.moveToLeft();
                break;
            case A:
                position.moveForward(garden);
                break;
        }
    }

    public void printPosition() {
        System.out.println(position.getX() + " " + position.getY() + " " + position.getOrientation().name());
    }

    public Position getPosition() {
        return position;
    }

}
