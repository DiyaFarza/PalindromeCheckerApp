import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Case-Insensitive & Space-Ignored Checker ---");
        System.out.print("Enter a phrase: ");
        String input = scanner.nextLine();

        // Step 1: Normalize the string
        // [^a-zA-Z0-9] matches anything that is NOT a letter or number
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Apply Two-Pointer logic (from UC4)
        if (isPalindrome(normalized)) {
            System.out.println("Result: Success! It is a palindrome.");
        } else {
            System.out.println("Result: Not a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String text) {
        if (text.isEmpty()) return true;

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}