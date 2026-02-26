import java.util.Scanner;
public class PalindromeCheckerApp {
    public static  void main(String[] args) {





                Scanner scanner = new Scanner(System.in);

                System.out.println("--- UC4: Character Array Palindrome Checker ---");
                System.out.print("Enter a string: ");
                String input = scanner.nextLine();

                // Step 1: Convert string to char[]
                char[] charArray = input.toLowerCase().toCharArray();

                if (isPalindrome(charArray)) {
                    System.out.println("\"" + input + "\" is a palindrome.");
                } else {
                    System.out.println("\"" + input + "\" is not a palindrome.");
                }

                scanner.close();
            }

            public static boolean isPalindrome(char[] chars) {
                // Step 2: Use Two-Pointer approach
                int left = 0;
                int right = chars.length - 1;

                while (left < right) {
                    // Step 3: Compare start & end characters
                    if (chars[left] != chars[right]) {
                        return false; // Mismatch found, not a palindrome
                    }
                    left++;  // Move forward
                    right--; // Move backward
                }
                return true; // All characters matched
            }
        }




