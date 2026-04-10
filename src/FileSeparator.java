


import java.io.*;
import java.util.Scanner;

public class FileSeparator {
    public static void main(String[] args) {
        String inputFile = "numbers.txt";
        String evenFile = "even.txt";
        String oddFile = "odd.txt";

        // Step 1: Read from numbers.txt and separate into even.txt and odd.txt
        try (Scanner reader = new Scanner(new File(inputFile));
             PrintWriter evenWriter = new PrintWriter(new FileWriter(evenFile));
             PrintWriter oddWriter = new PrintWriter(new FileWriter(oddFile))) {

            while (reader.hasNextInt()) {
                int num = reader.nextInt();
                if (num % 2 == 0) {
                    evenWriter.print(num + " ");
                } else {
                    oddWriter.print(num + " ");
                }
            }
        } catch (IOException e) {
            // If input file is missing, the program exits silently
            return;
        }

        // Step 2: Display the contents of both output files
        displayFileContent("Even File", evenFile);
        displayFileContent("Odd File", oddFile);
    }

    private static void displayFileContent(String label, String fileName) {
        System.out.print(label + ": ");
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine().trim());
            }
        } catch (IOException e) {
            System.out.println();
        }
    }
}