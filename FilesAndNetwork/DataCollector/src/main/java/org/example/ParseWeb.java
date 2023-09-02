package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParseWeb {

    static String htmlFile = parseFile("data/code.html");
    static Document document = Jsoup.parse(htmlFile);
    private static MskMetro mskMetro;

    static MskMetro createMskMetro() {
        mskMetro = new MskMetro();
        parseLines();
        parseStations(mskMetro.getNumber2line());
        return mskMetro;
    }

    static void parseLines() {

        Elements elements = document.select("span.js-metro-line");
        elements.forEach(element -> {

            Line line = new Line(
                    element.attr("data-line"),
                    element.text());
            mskMetro.addLine(line);
        });
    }

    static void parseStations(Set<Line> lines) {

        Elements elements = document.getElementsByClass("js-metro-stations");
        for (Element element : elements) {

            Elements listStation = element.getElementsByClass("single-station");
            listStation.forEach(e -> {
                String stationName = e.getElementsByClass("name").text();
                String lineNumber = element.attr("data-line");
                String hasConnected = e.select("span").attr("title");

                for (Line line : lines) {
                    if (line.getNumber().equals(lineNumber)) {
                        Station station = new Station(line, stationName);
                        if (!hasConnected.isEmpty()) {
                    station.setConnected("true");
                        }
                        line.addStation(station);
                    }
                }
            });
        }
    }

    static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> {
                builder.append(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
