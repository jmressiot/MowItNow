package org.mowitnow.bean;

import com.google.common.base.Objects;

/**
 * The garden
 */
public class Garden {

    private int xMax;
    private int yMax;

    public Garden(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public int getXMax() {
        return xMax;
    }

    public void setXMax(int xMax) {
        this.xMax = xMax;
    }

    public int getYMax() {
        return yMax;
    }

    public void setYMax(int yMax) {
        this.yMax = yMax;
    }



    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("xMax", xMax)
                .add("yMax", yMax)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Garden that = (Garden) o;

        return Objects.equal(this.xMax, that.xMax) &&
                Objects.equal(this.yMax, that.yMax);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(xMax, yMax);
    }
}
