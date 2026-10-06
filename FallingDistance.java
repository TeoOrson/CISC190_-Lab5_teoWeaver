import java.util.Scanner;

/**
 * Calculates the distance an object falls for each second entered by the user.
 * The program uses the falling-distance formula d = 0.5 * g * t^2.
 *
 * @author Teo
 * @version v1.0
 * @since 2026-10-04
 */
public class FallingDistance {
    public static final double ACCELERATION = 9.8;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double distance;
        int numOfSecs;

        System.out.print("Please enter how many seconds to compute: ");
        numOfSecs = keyboard.nextInt();

        System.out.println();
        System.out.println("Time(secs)\tDistance(m)");
        System.out.println("=========\t===========");

        for (int second = 1; second <= numOfSecs; second++) {
            distance = getDistance(second);
            System.out.printf("%-16d%.1f%n", second, distance);
        }

        keyboard.close();
    }

    /**
     * Calculates the distance an object falls for a given number of seconds.
     *
     * @param seconds the number of seconds the object has been falling
     * @return the distance fallen in meters
     */
    public static double getDistance(int seconds) {
        return 0.5 * ACCELERATION * Math.pow(seconds, 2);
    }
}
