package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class GetLinks extends RecursiveTask<Set<String>> {

    private String url;
    private static Set<String> linksFromTags = ConcurrentHashMap.newKeySet();

    public GetLinks(String url) {
        this.url = url;
    }

    @Override
    protected Set<String> compute() {
        Set<String> links = new TreeSet<>();
        List<GetLinks> taskList = new ArrayList<>();

        try {

            TimeUnit.MILLISECONDS.sleep(150);

            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .get();

            Elements elements = document.select("a");

            for (Element e : elements) {
                String link = e.absUrl("href").replaceAll("/$", "");
                if (!link.contains(url) ||
                        !linksFromTags.add(link)
                        || link.contains(".pdf")
                        || link.contains(".jpg")
                        || link.contains("#")) {
                        continue;
                }
                links.add(link);
                GetLinks task = new GetLinks(link);
                task.fork();
                taskList.add(task);
            }

        } catch (InterruptedException | IllegalArgumentException | IOException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

        for (GetLinks task : taskList) {
            links.addAll(task.join());
        }

        return links;
    }
}
