package com.sandarumk.imagecomparisonframework.ImageComparisonEngine;

import java.awt.image.BufferedImage;

/**
 * Created by dinu on 4/8/19.
 */
public class PixelMatcher {

    public static int getPixelToPixelMatchingScore(BufferedImage mockup, BufferedImage actual) {
        return 100 - getPixelToPixelDifferenceScore(mockup,actual) ;
    }

    private static int getPixelToPixelDifferenceScore(BufferedImage mockup, BufferedImage actual) {
        int differences = 0;
        for (int i = 0; i < mockup.getWidth(); i++) {
            for (int j = 0; j < mockup.getHeight(); j++) {
                if (mockup.getRGB(i, j) != actual.getRGB(i, j)) {
                    differences += 1;
                }
            }
        }
        return differences * 100 / (mockup.getWidth()*mockup.getHeight());
    }
}
