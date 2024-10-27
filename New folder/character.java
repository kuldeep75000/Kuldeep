import java.util.Scanner;

public class character {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String formatted = capitalizeWords(input);
        System.out.println("Formatted Sentence: " + formatted);

        scanner.close();
    }

    private static String capitalizeWords(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        StringBuilder formattedSentence = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                // Capitalize the first letter and convert the rest to lowercase
                String capitalizedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
                formattedSentence.append(capitalizedWord).append(" ");
            }
        }

        // Trim the trailing space and return the result
        return formattedSentence.toString().trim();
    }
}