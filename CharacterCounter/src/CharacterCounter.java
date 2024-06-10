import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharacterCounter {

    public static void main(String[] args) {
        // Test file
        String fileName = "hw4p1test.txt";

        try {
            // Counts the characters, words, and lines in the file
            int characters = countCharacters(fileName);
            int words = countWords(fileName);
            int lines = countLines(fileName);

            // Prints the results
            System.out.println("Characters: " + characters);
            System.out.println("Words: " + words);
            System.out.println("Lines: " + lines);
        } catch (IOException e) {
            System.out.println("File not found or error reading the file.");
        }
    }

    // Function to count the number of characters
    public static int countCharacters(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int characterCount = 0;
        int c;

        while ((c = reader.read()) != -1) {
            characterCount++;
        }

        reader.close();
        return characterCount;
    }

    // Function that counts the number of words
    public static int countWords(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int wordCount = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }

        reader.close();
        return wordCount;
    }

    // Function that counts the number of lines
    public static int countLines(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lineCount = 0;

        while (reader.readLine() != null) {
            lineCount++;
        }

        reader.close();
        return lineCount;
    }
}
