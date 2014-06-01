package org.mowitnow.parser;

import org.mowitnow.exception.ParserFileException;

public abstract class AbstractParser<T> {

    public static final String SEPARATOR = " ";
    private String line;

    public AbstractParser(String line) {
        this.line = line;
    }

    protected abstract T process();

    protected abstract String getRegex();

    public T decode() throws ParserFileException {

        if (!line.matches(getRegex())) {
            throw new ParserFileException("Please check the following line: " + line);
        }

        return process();
    }

    protected String getLine() {
        return line;
    }
}
