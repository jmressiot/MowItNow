package org.mowitnow.bean;

import com.google.common.base.Objects;

/**
 * Created by home on 09/05/2014.
 */
public class Position {
    private int x;
    private int y;
    private Orientation orientation;


    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }


    public void moveToRight() {
        this.orientation = orientation.moveToRight();
    }

    public void moveToLeft() {
        this.orientation = orientation.moveToLeft();
    }

    public void moveForward(Garden garden) {
        switch (orientation) {
            case N:
                if (y + 1 <= garden.getYMax()) {
                    y++;
                }
                break;
            case E:
                if (x + 1 <= garden.getXMax()) {
                    x++;
                }
                break;
            case S:
                if (y - 1 >= 0) {
                    y--;
                }
                break;
            case W:
                if (x - 1 >= 0) {
                    x--;
                }
                break;
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position that = (Position) o;

        return Objects.equal(this.x, that.x) &&
                Objects.equal(this.y, that.y) &&
                Objects.equal(this.orientation, that.orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y, orientation);
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("x", x)
                .add("y", y)
                .add("orientation", orientation)
                .toString();
    }


}
