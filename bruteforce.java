import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class DroneDeliverySystem {

    // ... (Previous code)

    static class Pair {
        Point p1, p2;
        double distance;

        Pair(Point p1, Point p2, double distance) {
            this.p1 = p1;
            this.p2 = p2;
            this.distance = distance;
        }
    }

    public static Pair bruteForceClosestPair(List<Point> points) {
        int n = points.size();
        Pair closestPair = new Pair(points.get(0), points.get(1), distance(points.get(0), points.get(1)));
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = distance(points.get(i), points.get(j));
                if (dist < closestPair.distance) {
                    closestPair = new Pair(points.get(i), points.get(j), dist);
                }
            }
        }
        return closestPair;
    }

    public static double distance(Point p1, Point p2) {
        return sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    // ... (Main method and other implementations)
}
