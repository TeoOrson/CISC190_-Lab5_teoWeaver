import java.util.Scanner;

/**
 * Tests whole numbers greater than 2 to determine whether they are prime.
 * The user may continue testing numbers until choosing to quit.
 *
 * @author Teo
 * @version v1.0
 * @since 2026-10-04
 */
public class Prime {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean isPrime;
        int number;
        String playAgain;

        do {
            System.out.print("Enter a whole number>2 (ie 19) to test if prime: ");
            number = keyboard.nextInt();

            isPrime = testForPrime(number);

            if (isPrime) {
                System.out.println(number + " is prime");
            } else {
                System.out.println(number + " is not prime");
            }

            System.out.print("Enter yes to test another number, no to quit. ");
            playAgain = keyboard.next();
        } while (playAgain.equalsIgnoreCase("yes"));

        keyboard.close();
    }

    /**
     * Tests a whole number to determine whether it is prime.
     *
     * @param inNumber the whole number to test
     * @return true if the number is prime; otherwise false
     */
    public static boolean testForPrime(int inNumber) {
        if (inNumber <= 1) {
            return false;
        }

        int inNumberSqRt = (int) Math.sqrt(inNumber);
        boolean isPrimeMeth = true;

        for (int i = 2; isPrimeMeth && i <= inNumberSqRt; i++) {
            if (inNumber % i == 0) {
                isPrimeMeth = false;
            }
        }

        return isPrimeMeth;
    }
}
