package org.mowitnow.parser;

import org.mowitnow.bean.Orientation;
import org.mowitnow.bean.Position;

/**
 * Created by home on 10/05/2014.
 */
public class PositionParser extends AbstractParser<Position> {

    public PositionParser(String line) {
        super(line);
    }

    @Override
    protected Position process() {
        String[] positionTab = line.split(SEPARATOR);
        return new Position(
                Integer.parseInt(positionTab[0]),
                Integer.parseInt(positionTab[1]),
                Orientation.valueOf(positionTab[2]));
    }


    @Override
    protected String getRegex() {
        return "^[0-9] [0-9] [NSEO]$";
    }


}
