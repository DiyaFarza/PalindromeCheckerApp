import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to check: ");
        String input = sc.nextLine();

        // Step 1: Clean the string (optional, but good practice)
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Recursive Call
        if (isPalindrome(cleanInput, 0, cleanInput.length() - 1)) {
            System.out.println("Result: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }
        sc.close();
    }

    /**
     * Recursive method to check palindrome
     * @param str The string to check
     * @param start The left pointer
     * @param end The right pointer
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str, int start, int end) {
        // Base Condition 1: If pointers cross, all characters matched
        if (start >= end) {
            return true;
        }

        // Base Condition 2: If characters at current positions don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Step: Move pointers inward
        return isPalindrome(str, start + 1, end - 1);
    }
}