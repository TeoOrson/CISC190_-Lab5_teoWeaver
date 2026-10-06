import java.util.Scanner;
import java.io.*;

/**
 * Reads sets of grades from an input text file and writes grade statistics
 * for each set to a user-specified output text file.
 *
 * @author Teo
 * @version v1.0
 * @since 2026-10-04
 */
public class Grades {
    private static final Scanner KEYBOARD = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String inFile;
        String outFile;

        inFile = getInFile();
        outFile = getOutFile();
        processFile(inFile, outFile);
    }

    /**
     * Uses Scanner to get and return an input file name, repeatedly prompting
     * until the requested file exists.
     *
     * @return name of the existing input file
     */
    public static String getInFile() {
        String fileName;

        System.out.print("Enter the name of the input file (ie input.txt): ");
        fileName = KEYBOARD.nextLine();
        File inputFile = new File(fileName);

        while (!inputFile.exists()) {
            System.out.println("The input file cannot be found.");
            System.out.print("Enter the name of the input file (ie input.txt): ");
            fileName = KEYBOARD.nextLine();
            inputFile = new File(fileName);
        }

        return fileName;
    }

    /**
     * Uses Scanner to get and return the desired output file name.
     *
     * @return name of the output file to create
     */
    public static String getOutFile() {
        System.out.print("Enter the name of the output file (ie output.txt): ");
        return KEYBOARD.nextLine();
    }

    /**
     * Reads grade sets from the input file and writes the number of each
     * letter grade, the high and low scores, and the average for each set.
     * A sentinel value of -1 ends each set of grades.
     *
     * @param inFileName name of the input file containing grade sets
     * @param outFileName name of the output file to create
     * @throws IOException if a file input/output error occurs
     */
    public static void processFile(String inFileName, String outFileName) throws IOException {
        int number;
        int As, Bs, Cs, Ds, Fs, min, max;
        int total, count;
        double avg;
        int set = 1;

        File inputFile = new File(inFileName);
        Scanner inStream = new Scanner(inputFile);
        PrintWriter outStream = new PrintWriter(outFileName);

        while (inStream.hasNextLine()) {
            String line = inStream.nextLine();
            Scanner lineScanner = new Scanner(line);

            As = Bs = Cs = Ds = Fs = count = 0;
            avg = 0.0;
            total = 0;

            if (!lineScanner.hasNextInt()) {
                lineScanner.close();
                continue;
            }

            number = lineScanner.nextInt();
            min = max = number;

            while (number != -1) {
                if (number < min) {
                    min = number;
                }
                if (number > max) {
                    max = number;
                }

                count++;
                total += number;

                if (number >= 90) {
                    As++;
                } else if (number >= 80) {
                    Bs++;
                } else if (number >= 70) {
                    Cs++;
                } else if (number >= 60) {
                    Ds++;
                } else {
                    Fs++;
                }

                if (lineScanner.hasNextInt()) {
                    number = lineScanner.nextInt();
                } else {
                    number = -1;
                }
            }

            outStream.println("Set " + set + " of grades calculated");
            set++;

            if (count == 0) {
                outStream.println("No grades to average");
            } else {
                outStream.println("Number of As: " + As);
                outStream.println("Number of Bs: " + Bs);
                outStream.println("Number of Cs: " + Cs);
                outStream.println("Number of Ds: " + Ds);
                outStream.println("Number of Fs: " + Fs);
                outStream.println("The high score was: " + max);
                outStream.println("The low score was: " + min);
                avg = (double) total / count;
                outStream.printf("The avg score is: %.1f%n", avg);
            }

            outStream.println();
            lineScanner.close();
        }

        System.out.println("Grade processing completed");
        System.out.println("You can retrieve the output file at, " + outFileName);

        inStream.close();
        outStream.close();
    }
}
