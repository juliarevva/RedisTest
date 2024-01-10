package core;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer extends Thread {

    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;


    public ImageResizer(File[] files, int newWidth, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for(File file: files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );

                BufferedImage newImage = resize(image,newWidth,newHeight);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
    public static BufferedImage resize(BufferedImage image,
                                       int targetWidth, int targetHeight) {

        return Scalr.resize(
                image,
                Scalr.Method.AUTOMATIC,
                Scalr.Mode.FIT_EXACT,
                targetWidth,
                targetHeight,
                Scalr.OP_ANTIALIAS);
    }


}

