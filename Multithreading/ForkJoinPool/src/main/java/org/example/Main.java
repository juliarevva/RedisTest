package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ForkJoinPool;


public class Main {

    private static StringBuilder builder = new StringBuilder();
    private static Path pathFile = Path.of("data/file.txt");

    public static void main(String[] args) {
//        String url = "https://sendel.ru";
//        String url = "https://skillbox.ru";
        String url = "https://lenta.ru";

        Set<String> linkList = new TreeSet<>(new ForkJoinPool().invoke(new GetLinks(url)));

        builder.append(url).append("\n");
        print(linkList, url, "");

        try {
            Files.write(pathFile, builder.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String s : linkList) {
            System.out.println(s);
        }
    }

    public static void print (Set<String> linkList, String url, String tab) {
        tab = tab + "\t";
        for (String link : linkList) {
            String parentLink = link.substring(0, link.lastIndexOf("/"));
            if (parentLink.contains(url)) {
                builder.append(tab).append(link).append("\n");
                print(linkList, link, tab);
            }
        }
    }
}