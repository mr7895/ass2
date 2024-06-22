import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class DroneDeliverySystem {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> generateRandomPoints(int numPoints) {
        Random random = new Random();
        List<Point> points = new ArrayList<>(numPoints);
        for (int i = 0; i < numPoints; i++) {
            points.add(new Point(random.nextDouble() * 100, random.nextDouble() * 100));
        }
        return points;
    }

    public static void main(String[] args) {
        List<Point> points = generateRandomPoints(1000);
        // Further implementation will go here
    }
}
