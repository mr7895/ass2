import java.util.Arrays;

public class DroneDeliverySystem {

    // ... (Previous code)

    public static Pair divideAndConquerClosestPair(List<Point> points) {
        List<Point> pointsSortedByX = new ArrayList<>(points);
        List<Point> pointsSortedByY = new ArrayList<>(points);
        pointsSortedByX.sort(Comparator.comparingDouble(p -> p.x));
        pointsSortedByY.sort(Comparator.comparingDouble(p -> p.y));
        return closestPair(pointsSortedByX, pointsSortedByY);
    }

    private static Pair closestPair(List<Point> pointsSortedByX, List<Point> pointsSortedByY) {
        int n = pointsSortedByX.size();
        if (n <= 3) {
            return bruteForceClosestPair(pointsSortedByX);
        }

        int mid = n / 2;
        Point midPoint = pointsSortedByX.get(mid);

        List<Point> leftOfCenter = pointsSortedByX.subList(0, mid);
        List<Point> rightOfCenter = pointsSortedByX.subList(mid, n);

        List<Point> leftOfCenterSortedByY = new ArrayList<>();
        List<Point> rightOfCenterSortedByY = new ArrayList<>();

        for (Point point : pointsSortedByY) {
            if (point.x <= midPoint.x) {
                leftOfCenterSortedByY.add(point);
            } else {
                rightOfCenterSortedByY.add(point);
            }
        }

        Pair closestPairLeft = closestPair(leftOfCenter, leftOfCenterSortedByY);
        Pair closestPairRight = closestPair(rightOfCenter, rightOfCenterSortedByY);

        Pair closestPair = closestPairLeft.distance < closestPairRight.distance ? closestPairLeft : closestPairRight;

        List<Point> strip = new ArrayList<>();
        for (Point point : pointsSortedByY) {
            if (Math.abs(point.x - midPoint.x) < closestPair.distance) {
                strip.add(point);
            }
        }

        return findClosestStripPair(strip, closestPair.distance, closestPair);
    }

    private static Pair findClosestStripPair(List<Point> strip, double d, Pair closestPair) {
        int size = strip.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip.get(j).y - strip.get(i).y) < d; j++) {
                double dist = distance(strip.get(i), strip.get(j));
                if (dist < closestPair.distance) {
                    closestPair = new Pair(strip.get(i), strip.get(j), dist);
                }
            }
        }
        return closestPair;
    }

    // ... (Main method and other implementations)
}
