import java.util.*;

/* ===== STRATEGY INTERFACE ===== */
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

/* ===== STACK STRATEGY ===== */
class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();

        for(char c : text.toCharArray())
            stack.push(c);

        for(char c : text.toCharArray())
            if(c != stack.pop())
                return false;

        return true;
    }
}

/* ===== DEQUE STRATEGY ===== */
class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();

        for(char c : text.toCharArray())
            deque.addLast(c);

        while(deque.size() > 1)
            if(deque.removeFirst() != deque.removeLast())
                return false;

        return true;
    }
}

/* ===== CONTEXT CLASS ===== */
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        return strategy.isPalindrome(text);
    }
}

/* ===== MAIN CLASS ===== */
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy = new DequeStrategy();
        PalindromeChecker checker = new PalindromeChecker(strategy);

        if(checker.check(input))
            System.out.println("It is a Palindrome");
        else
            System.out.println("Not a Palindrome");

        sc.close();
    }
}
