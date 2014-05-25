package org.mowitnow;

import com.google.common.collect.Lists;
import org.mowitnow.bean.Garden;
import org.mowitnow.bean.Mower;
import org.mowitnow.bean.Order;
import org.mowitnow.bean.Position;
import org.mowitnow.exception.ParserFileException;
import org.mowitnow.parser.GardenParser;
import org.mowitnow.parser.OrdersParser;
import org.mowitnow.parser.PositionParser;

import java.util.List;

/**
 * Created by home on 10/05/2014.
 */
public class Programmer {

    private static final int MIN_LINES = 3;
    private static final String ERROR_MSG = "Error when reading file: ";

    private List<String> lines;
    private List<Mower> mowers;


    public Programmer(List<String> lines) {
        this.lines = lines;
        this.mowers = Lists.newArrayList();
    }


    /**
     * Execute the programmer
     * 1. read the file
     * 2. decode the file
     * 3. execute the program
     *
     * @throws org.mowitnow.exception.ParserFileException
     */
    public void execute() throws ParserFileException {
        decodeLines();
        launchMowers();
    }

    /**
     * Retrieve the mowers
     */
    public List<Mower> getMowers() {
        return mowers;
    }


    private void launchMowers() {
        for (Mower mower : mowers) {
            mower.move();
            mower.printPosition();
        }
    }


    /**
     * Decode the lines in order to instantiate the mowers
     *
     * @throws org.mowitnow.exception.ParserFileException
     */
    private void decodeLines() throws ParserFileException {

        if (lines == null) {
            throw new ParserFileException(ERROR_MSG + "no line in file");
        }

        // parse the garden
        Garden garden = new GardenParser(lines.get(0)).decode();

        int index = 0;
        // parse the mowers
        while (mowers.size() < getNbMowers()) {
            Position position = new PositionParser(lines.get(++index)).decode();
            List<Order> orders = new OrdersParser(lines.get(++index)).decode();
            mowers.add(new Mower(garden, position, orders));
        }
    }


    /**
     * Calculate the numbers of mowers detected in the file
     *
     * @return the numbers of mowers
     * @throws org.mowitnow.exception.ParserFileException
     */
    private int getNbMowers() throws ParserFileException {
        if (lines.size() < MIN_LINES || lines.size() % 2 == 0) {
            throw new ParserFileException(ERROR_MSG + "the numbers of lines is incorrect");
        }

        return (lines.size() - 1) / 2;
    }


}
