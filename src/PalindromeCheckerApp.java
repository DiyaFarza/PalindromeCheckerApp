import java.util.Scanner;

public class PalindromeCheckerApp {

    // Internal Node class to ensure visibility
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        // Step 1: Convert string to linked list
        Node head = convertToLinkedList(input);

        // Step 2, 3, & 4: Logic to check palindrome
        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is NOT a palindrome.");
        }
        sc.close();
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Use Fast and Slow Pointer to find the middle
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half in-place
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Compare the two halves
        Node temp = secondHalf;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        return true;
    }

    // Helper: Reverse a linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Helper: String -> Linked List
    private static Node convertToLinkedList(String s) {
        if (s.isEmpty()) return null;
        Node head = new Node(s.charAt(0));
        Node current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current = current.next;
        }
        return head;
    }
}