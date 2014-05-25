package org.mowitnow.bean;

public enum Orientation {

    // North
    N("W", "E"),
    // East
    E("N", "S"),
    // South
    S("E", "W"),
    // West
    W("S", "N");


    private String toLeft;
    private String toRight;

    private Orientation(String toLeft, String toRight) {
        this.toLeft = toLeft;
        this.toRight = toRight;
    }

    public Orientation moveToLeft() {
        return Orientation.valueOf(toLeft);
    }

    public Orientation moveToRight() {
        return Orientation.valueOf(toRight);
    }
}
