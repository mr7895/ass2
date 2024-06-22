// Adding visualization (simple console output)

public class DroneDeliverySystem {

    // ... (Previous code)

    public static void visualizePath(List<Point> points) {
        Set<Point> visited = new HashSet<>();
        Point currentPoint = points.get(0);
        visited.add(currentPoint);
        System.out.println("Drone's Path:");
       
