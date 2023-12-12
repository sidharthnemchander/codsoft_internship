import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the filename
        System.out.print("Enter text or provide a file path to count words: ");
        String input = scanner.nextLine();

        // Check if input is empty
        if (input.trim().isEmpty()) {
            System.out.println("Input is empty. Please enter text or provide a valid file path.");
            return;
        }

        String[] words;
        if (input.endsWith(".txt")) {
            // Read the content of the file
            words = readWordsFromFile(input);
        } else {
            words = input.split("[\\p{Punct}]+");
        }

        int wordCount = words.length;

        System.out.println("Total number of words: " + wordCount);

        displayWordStatistics(words);

        scanner.close();
    }

    private static String[] readWordsFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            // Join the lines into a single string
            String content = String.join(" ", lines);

            // Split the content into words
            return content.split("[\\s\\p{Punct}]+");
        } catch (IOException e) {
            System.out.println("Error reading the file. Please provide a valid file path.");
            System.exit(1);
        }
        return new String[0];
    }

    private static void displayWordStatistics(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            String lowercaseWord = word.toLowerCase();
            wordFrequency.put(lowercaseWord, wordFrequency.getOrDefault(lowercaseWord, 0) + 1);
        }

        System.out.println("Number of unique words: " + wordFrequency.size());

        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
