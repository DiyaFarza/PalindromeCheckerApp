import java.util.*;

public class PalindromeCheckerApp {

    /* ===== Algorithm 1 — Reverse String ===== */
    public static boolean reverseMethod(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    /* ===== Algorithm 2 — Two Pointer ===== */
    public static boolean twoPointerMethod(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    /* ===== Algorithm 3 — Stack ===== */
    public static boolean stackMethod(String text) {
        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray())
            stack.push(c);

        for (char c : text.toCharArray())
            if (c != stack.pop())
                return false;

        return true;
    }

    /* ===== Utility Timer ===== */
    public static long measureTime(String text, java.util.function.Function<String, Boolean> method) {
        long start = System.nanoTime();
        method.apply(text);
        long end = System.nanoTime();
        return (end - start);
    }

    /* ===== MAIN ===== */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("\nRunning Performance Comparison...\n");

        long reverseTime = measureTime(input, PalindromeCheckerApp::reverseMethod);
        long twoPointerTime = measureTime(input, PalindromeCheckerApp::twoPointerMethod);
        long stackTime = measureTime(input, PalindromeCheckerApp::stackMethod);

        boolean result = twoPointerMethod(input);

        System.out.println("Palindrome Result: " + (result ? "YES" : "NO"));

        System.out.println("\nExecution Time (nanoseconds)");
        System.out.println("----------------------------------");
        System.out.println("Reverse Method   : " + reverseTime);
        System.out.println("Two Pointer      : " + twoPointerTime);
        System.out.println("Stack Method     : " + stackTime);

        sc.close();
    }
}