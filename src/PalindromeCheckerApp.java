import java.util.Scanner;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static  void main(String[] args) {






                Scanner scanner = new Scanner(System.in);

                System.out.println("--- UC5: Stack-Based Palindrome Checker ---");
                System.out.print("Enter a string: ");
                String input = scanner.nextLine();

                // Normalize input: remove case sensitivity
                String cleanedInput = input.toLowerCase();

                if (isPalindrome(cleanedInput)) {
                    System.out.println("\"" + input + "\" is a palindrome.");
                } else {
                    System.out.println("\"" + input + "\" is not a palindrome.");
                }

                scanner.close();
            }

            public static boolean isPalindrome(String input) {
                Stack<Character> stack = new Stack<>();

                // Step 1: Push all characters onto the stack
                for (int i = 0; i < input.length(); i++) {
                    stack.push(input.charAt(i));
                }

                // Step 2: Pop and compare with the original string characters
                for (int i = 0; i < input.length(); i++) {
                    // Pop gives the characters in reverse order
                    if (input.charAt(i) != stack.pop()) {
                        return false; // Mismatch found
                    }
                }

                return true; // Sequence matched perfectly
            }
        }




