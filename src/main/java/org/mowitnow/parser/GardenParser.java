package org.mowitnow.parser;

import org.mowitnow.bean.Garden;

public class GardenParser extends AbstractParser<Garden> {


    public GardenParser(String line) {
        super(line);
    }

    @Override
    protected Garden process() {
        String[] gardenParams = line.split(SEPARATOR);
        return new Garden(Integer.parseInt(gardenParams[0]), Integer.parseInt(gardenParams[1]));
    }

    @Override
    protected String getRegex() {
        return "^[0-9] [0-9]$";
    }


}
