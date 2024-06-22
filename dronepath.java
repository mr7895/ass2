import java.util.HashSet;
import java.util.Set;

public class DroneDeliverySystem {

    // ... (Previous code)

    public static double calculateTotalDistance(List<Point> points) {
        double totalDistance = 0.0;
        Set<Point> visited = new HashSet<>();
        Point currentPoint = points.get(0);
        visited.add(currentPoint);

        while (visited.size() < points.size()) {
            Pair closestPair = bruteForceClosestPairExcluding(points, visited, currentPoint);
            totalDistance += closestPair.distance;
            currentPoint = visited.contains(closestPair.p1) ? closestPair.p2 : closestPair.p1;
            visited.add(currentPoint);
        }
        return totalDistance;
    }

    private static Pair bruteForceClosestPairExcluding(List<Point> points, Set<Point> visited, Point fromPoint) {
        Pair closestPair = new Pair(fromPoint, null, Double.MAX_VALUE);
        for (Point point : points) {
            if (!visited.contains(point)) {
                double dist = distance(fromPoint, point);
                if (dist < closestPair.distance) {
                    closestPair = new Pair(fromPoint, point, dist);
                }
            }
        }
        return closestPair;
    }

    // ... (Main method and other implementations)
}
