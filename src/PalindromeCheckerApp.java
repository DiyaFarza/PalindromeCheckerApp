import java.util.Scanner;

// Service Class: Encapsulates the logic
class PalindromeService {

    /**
     * Checks if a string is a palindrome using internal logic.
     * This method is encapsulated and can be reused in other apps.
     */
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        // Internal Normalization (Encapsulated)
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Main Application Class
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the Service Object
        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter text to validate: ");
        String userInput = scanner.nextLine();

        // Using the service object
        if (service.checkPalindrome(userInput)) {
            System.out.println("Result: The input is a valid palindrome.");
        } else {
            System.out.println("Result: Not a palindrome.");
        }

        scanner.close();
    }
}