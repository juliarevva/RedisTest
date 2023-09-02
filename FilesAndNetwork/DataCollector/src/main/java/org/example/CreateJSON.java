package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

public class CreateJSON {

    public static void createMskMap(Set<Line> lines) {

        String path = "data/stations.json";
        JSONArray lineArray = new JSONArray();
        JSONArray stationArray = new JSONArray();
        JSONObject moscowMetro = new JSONObject();

        for (Line line : lines) {

            JSONObject lineJson = new JSONObject();
            lineJson.put("number", line.getName());
            lineJson.put("name", line.getName());
            lineArray.add(lineJson);
            moscowMetro.put("lines", lineArray);

            JSONObject stationJson = new JSONObject();
            stationJson.put(line.getNumber(), line.getStationsName());
            stationArray.add(stationJson);
            moscowMetro.put("stations", stationArray);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), moscowMetro);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createStationsList(Set<Line> lineMap, String path) {

        String pathJsonFile = "data/stations.json";

        List<String> jsonFileList = FindFiles.getJsonFileList(path);
        List<String> csvFileList = FindFiles.getCsvFileList(path);

        ParsingJSON parsingJSON = new ParsingJSON();
        ParsingCSV parsingCSV = new ParsingCSV();


        parsingJSON.createDepthsStationList(jsonFileList, lineMap);
        parsingCSV.createDateOpeningList(csvFileList, lineMap);


        JSONArray stationArray = new JSONArray();

        for (Line line : lineMap) {
            for (Station station : line.getStations()) {
                JSONObject stationJson = new JSONObject();
                stationJson.put("name", station.getStationName());
                stationJson.put("line", station.getLineNumber());

                if (station.getDepth() != null) {
                    stationJson.put("depth", station.getDepth());
                }

                if (station.getDate() != null) {
                    stationJson.put("date", station.getDate());
                }

                if (station.getConnected() != null) {
                    stationJson.put("hasConnection", station.getConnected());
                }
                
                stationArray.add(stationJson);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(pathJsonFile), stationArray);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}









