package core;

import core.ImageResizer;

import java.io.File;

public class Main {

    public static int newWidth = 300;

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        int countProcessors = runtime.availableProcessors();

        String srcFolder = "src/originalPhotos";
        String dstFolder = "src/newPhotos";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int countPhoto = files.length / countProcessors;
        for(int i = 1; i <= countProcessors; i++) {
            int startList = 0;
            int finishList = countPhoto;

            File[] newFiles = new File[finishList];
            System.arraycopy(files, 0, newFiles, 0, newFiles.length);
            ImageResizer resizer1 = new ImageResizer(newFiles, newWidth, dstFolder, start);
            resizer1.start();

            startList = startList + countPhoto;
            finishList = finishList + countPhoto;
        }

        ImageResizer resizer = new ImageResizer(files, newWidth, dstFolder, start);
        resizer.start();
    }
}
