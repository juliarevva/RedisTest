package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParsingJSON {

    public static void createDepthsStationList(List<String> list, Set<Line> lines) {
        try {
            JSONParser parser = new JSONParser();
            for (String s : list) {
                JSONArray jsonData = (JSONArray) parser.parse(getJsonFile(s));
                parseDepth(jsonData, lines);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void parseDepth(JSONArray depthArray, Set<Line> lines) {

        depthArray.forEach(depthObject -> {
            JSONObject depthJsonObject = (JSONObject) depthObject;
            String nameStation = (String) depthJsonObject.get("station_name");
            String depthStation;

            if (depthJsonObject.get("depth").equals("?") || depthJsonObject.get("depth").equals("0")) {
                depthStation = null;
            } else {
                depthStation = (String) depthJsonObject.get("depth");
            }

            for (Line line : lines) {
                for (Station station : line.getStations()) {

                    if (station.getStationName()
                            .replaceAll("ё", "e")
                            .toLowerCase()
                            .equals(nameStation
                                    .replaceAll("ё", "e")
                                    .toLowerCase())) {
                        station.setDepth(depthStation);
                        break;
                    }
                }
            }
        });
    }


    public static String getJsonFile(String path) {

        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line ->
                    builder.append(line));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }
}
