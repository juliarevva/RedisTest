package org.example;

import java.util.*;

public class MskMetro {

    private final Set<Line> number2line;

    public MskMetro() {
        number2line = new LinkedHashSet<>();
    }

    public void addLine(Line line) {
        number2line.add(line);
    }

    public Set<Line> getNumber2line() {
        return number2line;
    }
}