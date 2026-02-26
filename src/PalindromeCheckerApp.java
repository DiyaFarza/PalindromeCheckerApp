import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
public class PalindromeCheckerApp {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);






                System.out.println("--- UC7: Deque-Based Optimized Palindrome Checker ---");
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
                Deque<Character> deque = new ArrayDeque<>();

                // Step 1: Insert all characters into the deque
                for (int i = 0; i < input.length(); i++) {
                    deque.addLast(input.charAt(i));
                }

                // Step 2: Remove first and last characters and compare
                // We continue as long as there is more than 1 character to compare
                while (deque.size() > 1) {
                    char first = deque.removeFirst();
                    char last = deque.removeLast();

                    if (first != last) {
                        return false; // Mismatch found
                    }
                }

                // If we reach here, it's a palindrome (size is 0 or 1)
                return true;
            }
        }












