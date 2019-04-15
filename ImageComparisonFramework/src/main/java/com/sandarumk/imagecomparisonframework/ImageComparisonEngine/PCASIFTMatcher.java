package com.sandarumk.imagecomparisonframework.ImageComparisonEngine;

import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.feature.local.matcher.LocalFeatureMatcher;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.feature.local.engine.DoGSIFTEngine;
import org.openimaj.image.feature.local.keypoints.Keypoint;
import org.openimaj.util.pair.Pair;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by dinu
 * on 4/15/19.
 */
public class PCASIFTMatcher {
    public static double getPCASIFTBasedMatchingScore(BufferedImage mockup, BufferedImage actual) {
        MBFImage query = ImageUtilities.createMBFImage(mockup, true);
        MBFImage target = ImageUtilities.createMBFImage(actual, true);
        DoGSIFTEngine engine = new DoGSIFTEngine();

        LocalFeatureList<Keypoint> queryKeypoints = engine.findFeatures(query.flatten());
        LocalFeatureList<Keypoint> targetKeypoints = engine.findFeatures(target.flatten());

        double keypointSimilarityScore = calculateSimilarityScore(queryKeypoints,targetKeypoints);
        double keypointMatchingScore = targetKeypoints.size() * 100/ Math.max(queryKeypoints.size(),targetKeypoints.size());
        return keypointMatchingScore*keypointSimilarityScore;
    }

    private static double calculateSimilarityScore(LocalFeatureList<Keypoint> queryKeypoints, LocalFeatureList<Keypoint> targetKeypoints) {
        LocalFeatureMatcher<Keypoint> matcher = new PCAMatcher<>();
        matcher.setModelFeatures(queryKeypoints);
        matcher.findMatches(targetKeypoints);
        List<Pair<Keypoint>> matches = matcher.getMatches();
        return matches.size()*100/queryKeypoints.size();
    }
}
