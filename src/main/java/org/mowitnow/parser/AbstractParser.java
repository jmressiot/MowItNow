package org.mowitnow.parser;

import org.mowitnow.exception.ParserFileException;

/**
 * Created by home on 10/05/2014.
 */
public abstract class AbstractParser<T> {

    public static final String SEPARATOR = " ";
    protected String line;

    public AbstractParser(String line) {
        this.line = line;
    }

    protected abstract T process();

    protected abstract String getRegex();

    public T decode() throws ParserFileException {

        if (!line.matches(getRegex())) {
            throw new ParserFileException("Error when parsing file on line: " + line);
        }

        return process();
    }
}
