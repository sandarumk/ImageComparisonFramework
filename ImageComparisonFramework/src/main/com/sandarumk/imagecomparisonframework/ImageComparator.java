package main.com.sandarumk.imagecomparisonframework;

import main.com.sandarumk.imagecomparisonframework.ImageComparisonEngine.PixelMatcher;

import java.awt.image.BufferedImage;

/**
 * Created by dinu on 4/8/19.
 */
public class ImageComparator {

    public static double getPixelToPixelMatchingScore(BufferedImage mockup, BufferedImage actual) {
        return PixelMatcher.getPixelToPixelMatchingScore(mockup,actual);
    }

    public static double getLayoutMatchingScore(BufferedImage mockup, BufferedImage actual) {
        return 0.0;
    }

    public static double getSIFTBasedMatchingScore(BufferedImage mockup, BufferedImage actual) {
        return 0.0;
    }

    public static double getPCASIFTBasedMatchingScore(BufferedImage mockup, BufferedImage actual) {
        return 0.0;
    }

    public static double getCSIFTBasedMatchingScore(BufferedImage mockup, BufferedImage actual) {
        return 0.0;
    }

    public static double getBlobDetectionBasedMatchingScore(BufferedImage mockup, BufferedImage actual) {
        return 0.0;
    }
}
