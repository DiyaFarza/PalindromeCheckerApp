import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class PalindromeCheckerApp {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC6: Queue + Stack Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input for comparison
        String cleanedInput = input.toLowerCase();

        if (isPalindrome(cleanedInput)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String input) {
        // Queue follows FIFO (Original Order)
        Queue<Character> queue = new LinkedList<>();
        // Stack follows LIFO (Reverse Order)
        Stack<Character> stack = new Stack<>();

        // Step 1: Enqueue and Push characters
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            queue.add(c);
            stack.push(c);
        }

        // Step 2: Compare Dequeue vs Pop
        while (!stack.isEmpty()) {
            // Dequeue gets the first char, Pop gets the last char
            if (!queue.remove().equals(stack.pop())) {
                return false; // Mismatch detected
            }
        }

        return true; // All characters matched
    }
}











