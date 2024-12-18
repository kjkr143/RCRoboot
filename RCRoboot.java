import java.util.*;

public class RCRoboot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] warehouseDimensions = scanner.nextLine().split(" ");      // 5 5
            if (warehouseDimensions.length != 2) throw new IllegalArgumentException("Invalid warehouse dimensions.");
            int maxX = Integer.parseInt(warehouseDimensions[0]); //5
            int maxY = Integer.parseInt(warehouseDimensions[1]); //5
            if (maxX < 0 || maxY < 0) throw new IllegalArgumentException("Warehouse dimensions must be non-negative.");

            while (scanner.hasNextLine()) {
                String positionLine = scanner.nextLine();  // 1 0
                String commandLine = scanner.hasNextLine() ? scanner.nextLine() : ""; //N

                String[] position = positionLine.split(" ");
                if (position.length != 3) throw new IllegalArgumentException("Invalid robot position format.");
                int x = Integer.parseInt(position[0]);//1
                int y = Integer.parseInt(position[1]);//0
                char orientation = position[2].toUpperCase().charAt(0);//N
                if (x < 0 || x > maxX || y < 0 || y > maxY) {
                    System.out.println("Robot starting position is out of bounds. Skipping...");
                    continue;
                }

                //  commands //MMRMMLMMR
                for (char command : commandLine.toUpperCase().toCharArray()) {
                    switch (command) {
                        case 'L':
                            orientation = turnLeft(orientation);
                            break;
                        case 'R':
                            orientation = turnRight(orientation);
                            break;
                        case 'M':
                            int[] newPosition = moveForward(x, y, orientation, maxX, maxY);
                            x = newPosition[0];
                            y = newPosition[1];
                            break;
                        default:
                            System.out.println("Invalid command '" + command + "'. Skipping...");
                    }
                }
                System.out.println(x + " " + y + " " + orientation);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static char turnLeft(char orientation) {
        return switch (orientation) {
            case 'N' -> 'W';
            case 'W' -> 'S';
            case 'S' -> 'E';
            case 'E' -> 'N';
            default -> throw new IllegalArgumentException("Invalid orientation: " + orientation);
        };
    }

    private static char turnRight(char orientation) {
        return switch (orientation) {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> throw new IllegalArgumentException("Invalid orientation: " + orientation);
        };
    }

    private static int[] moveForward(int x, int y, char orientation, int maxX, int maxY) {
        switch (orientation) {
            case 'N': if (y + 1 <= maxY) y++; break;
            case 'E': if (x + 1 <= maxX) x++; break;
            case 'S': if (y - 1 >= 0) y--; break;
            case 'W': if (x - 1 >= 0) x--; break;
        }
        return new int[]{x, y};
    }
}
