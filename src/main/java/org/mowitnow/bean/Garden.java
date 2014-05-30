package org.mowitnow.bean;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class Garden {

    private int xMax;
    private int yMax;

    public Garden(int xMax, int yMax) {
        Preconditions.checkArgument(xMax > 0);
        Preconditions.checkArgument(yMax > 0);

        this.xMax = xMax;
        this.yMax = yMax;
    }

    public int getXMax() {
        return xMax;
    }

    public int getYMax() {
        return yMax;
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


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("xMax", xMax)
                .add("yMax", yMax)
                .toString();
    }
}
