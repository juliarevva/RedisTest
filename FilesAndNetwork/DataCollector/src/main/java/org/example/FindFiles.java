package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFiles {

    public static List<String> getJsonFileList(String path) {
        List<String> jsonFileList = new ArrayList<>();
        List<File> list = new ArrayList<>();
        searchFile(path, list)
                .stream()
                .filter(file -> file.getName().endsWith(".json"))
                .forEach(e ->
                        jsonFileList.add(e.toString()));

        return jsonFileList;
    }

    public static List<String> getCsvFileList(String path) {
        List<String> csvFileList = new ArrayList<>();
        List<File> list = new ArrayList<>();
        searchFile(path, list)
                .stream()
                .filter(file -> file.getName().endsWith(".csv"))
                .forEach(e ->
                        csvFileList.add(e.toString()));

        return csvFileList;
    }

    public static List<File> searchFile(String path, List<File> list) {

        File directory = new File(path);
        if (directory.isDirectory()) {
            File[] directoryFiles = directory.listFiles();
            if (directoryFiles != null) {
                for (File directoryFile : directoryFiles) {
                    if (directoryFile.isDirectory()) {
                        searchFile(String.valueOf(directoryFile), list);
                    } else {
                        if (directoryFile.getName().endsWith(".json") || directoryFile.getName().endsWith(".csv"))
                            list.add(directoryFile);
                    }
                }
            }
        }
        return list;
    }
}
