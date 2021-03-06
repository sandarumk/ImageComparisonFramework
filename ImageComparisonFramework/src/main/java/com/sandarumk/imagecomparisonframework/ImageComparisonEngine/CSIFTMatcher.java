package com.sandarumk.imagecomparisonframework.ImageComparisonEngine;

import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.feature.local.matcher.BasicTwoWayMatcher;
import org.openimaj.feature.local.matcher.LocalFeatureMatcher;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.feature.local.engine.DoGColourSIFTEngine;
import org.openimaj.image.feature.local.keypoints.Keypoint;
import org.openimaj.util.pair.Pair;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by dinu
 * on 4/15/19.
 */
public class CSIFTMatcher {
    public static double getCSIFTBasedMatchingScore(BufferedImage mockup, BufferedImage actual) {
        MBFImage query = ImageUtilities.createMBFImage(mockup, true);
        MBFImage target = ImageUtilities.createMBFImage(actual, true);
        DoGColourSIFTEngine engine = new DoGColourSIFTEngine();

        LocalFeatureList<Keypoint> queryKeypoints = engine.findFeatures(query);
        LocalFeatureList<Keypoint> targetKeypoints = engine.findFeatures(target);

        double keypointSimilarityScore = calculateSimilarityScore(queryKeypoints,targetKeypoints);
        double keypointMatchingScore = targetKeypoints.size() * 100/ Math.max(queryKeypoints.size(),targetKeypoints.size());
        return keypointMatchingScore*keypointSimilarityScore;
    }

    private static double calculateSimilarityScore(LocalFeatureList<Keypoint> queryKeypoints, LocalFeatureList<Keypoint> targetKeypoints) {
        LocalFeatureMatcher<Keypoint> matcher = new BasicTwoWayMatcher<>();
        matcher.setModelFeatures(queryKeypoints);
        matcher.findMatches(targetKeypoints);
        List<Pair<Keypoint>> matches = matcher.getMatches();
        return matches.size()*100/queryKeypoints.size();
    }
}
