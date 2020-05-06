### Image Comparison Framework

You can use this framework to compare the similariy of two images. This is developed to be used in the context of mobile application development where you can provide your mockup and the screenshot of the actual application and you can get a quantifiable score on their similarity.

### API Methods Available

##### `getOverallMatchingScore(BufferedImage mockup, BufferedImage actual)`

This will output an overall matching score between two images by comapring them in pixel by pixel basis.

##### `getLayoutMatchingScore(BufferedImage mockup, BufferedImage actual)`

This will output a matching score based on layout of the two images. This is implemented for the context of mobile application testing and currently use CSIFT algorithm as the underlying algorithm. This is our recommended score for layout matching. However, this will be suitable only for image intensive applications.

##### `getSIFTBasedMatchingScore(BufferedImage mockup, BufferedImage actual)`

This will output a matching score for the layout of the two images using SIFT algorithm.

##### `getPCASIFTBasedMatchingScore(BufferedImage mockup, BufferedImage actual)`

This will output a matching score for the layout of the two images using PCA-SIFT algorithm.

##### `getCSIFTBasedMatchingScore(BufferedImage mockup, BufferedImage actual)`
This will output a matching score for the layout of the two images using CSIFT algorithm. This is our currently recommended algorithm for layout comparison and hence our `getLayoutMatchingScore` API provides the same. If you do not want the underlying algorithm to be changed in the future with latest development, use this API instead.

##### `getBlobDetectionBasedMatchingScore(BufferedImage mockup, BufferedImage actual)`
This will output a matching score for the layout of the two images using a blob detection and comparison algorithm. This is more suitable for text intensive applications as this will convert all text to blobs so you don't have to match the text in mockup and actual.