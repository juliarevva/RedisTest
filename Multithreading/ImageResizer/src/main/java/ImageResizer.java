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

//                public static BufferedImage resize(int targetWidth,
//                int targetHeight, BufferedImage.) {}

//                private BufferedImage copyToBufferedImage()  {
//                    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//                    for (int i = 0; i < height; i++)
//                        for (int j = 0; j < width; j++)
//                            bi.setRGB(j, i, pixels[i*width +j]);
//                    return bi;

//                BufferedImage newImage = new BufferedImage(
//                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
//
//                int widthStep = image.getWidth() / newWidth;
//                int heightStep = image.getHeight() / newHeight;
//
//                for (int x = 0; x < newWidth; x++) {
//                    for (int y = 0; y < newHeight; y++) {
//                        int rgb = image.getRGB(x * widthStep, y * heightStep);
//                        newImage.setRGB(x, y, pixels[x*newWidth +y]);
//                    }
//                }
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

