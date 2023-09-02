package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите путь к директории с файлами .json  и .csv");

        String path = new Scanner(System.in).nextLine();

//        String path = "/Users/uliarevva/Downloads/data";

        CreateJSON.createMskMap(ParseWeb.createMskMetro().getNumber2line());
        CreateJSON.createStationsList(ParseWeb.createMskMetro().getNumber2line(), path);

        System.out.println("Файлы map.json и station.json созданы в директории data текущего проекта");
    }
}
