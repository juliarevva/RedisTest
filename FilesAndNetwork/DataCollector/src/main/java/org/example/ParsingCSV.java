package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Set;

public class ParsingCSV {

    public static void createDateOpeningList(List<String> list, Set<Line> lines) {

        try {

            for (String s : list) {
                List<String> strings = Files.readAllLines(Paths.get(s));

                boolean firstLine = true;
                for (String string : strings) {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }

                    String[] fragments = string.split(",");
                    if (fragments.length != 2) {
                        System.out.println("Wrong line: " + string);
                        continue;
                    }

                    String nameStation = fragments[0];
                    DateTimeFormatter dateFormatter =
                            DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    LocalDate date = LocalDate.parse(fragments[1], dateFormatter);

                    for (Line line : lines) {
                        for (Station station : line.getStations()) {
                            if (station.getStationName()
                                    .replaceAll("ё", "e")
                                    .toLowerCase()
                                    .equals(nameStation
                                            .replaceAll("ё", "e")
                                            .toLowerCase())) {
                                station.setDate(date.format(dateFormatter));
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Ошибка чтения файла с датами", ex);
        }
    }
}
