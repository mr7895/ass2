public class DroneDeliverySystem {

    // ... (Previous code)

    public static void main(String[] args) {
        List<Point> randomPoints = generateRandomPoints(1000);
        Pair bruteForcePair = bruteForceClosestPair(randomPoints);
        System.out.println("Brute-Force Closest Pair: (" + bruteForcePair.p1.x + ", " + bruteForcePair.p1.y + 
                           ") and (" + bruteForcePair.p2.x + ", " + bruteForcePair.p2.y + 
                           ") with distance: " + bruteForcePair.distance);

        Pair divideAndConquerPair = divideAndConquerClosestPair(randomPoints);
        System.out.println("Divide-and-Conquer Closest Pair: (" + divideAndConquerPair.p1.x + ", " + divideAndConquerPair.p1.y + 
                           ") and (" + divideAndConquerPair.p2.x + ", " + divideAndConquerPair.p2.y + 
                           ") with distance: " + divideAndConquerPair.distance);

        double totalDistance = calculateTotalDistance(randomPoints);
        System.out.println("Total Distance Travelled by Drone: " + totalDistance);

        // Evaluate performance
        long startTime = System.currentTimeMillis();
        bruteForceClosestPair(randomPoints);
        long endTime = System.currentTimeMillis();
        System.out.println("Brute-Force Time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        divideAndConquerClosestPair(randomPoints);
        endTime = System.currentTimeMillis();
        System.out.println("Divide-and-Conquer Time: " + (endTime - startTime) + "ms");
    }
}
