
public class PalindromeCheckerApp {
    public static  void main(String[] args) {

                String str = "madam";
                String reversed = "";

                // Reverse the string
                for (int i = str.length() - 1; i >= 0; i--) {
                    reversed += str.charAt(i);
                }

                // Check if original and reversed strings are equal
                if (str.equals(reversed)) {
                    System.out.println(str + " is a palindrome.");
                } else {
                    System.out.println(str + " is not a palindrome.");
                }
            }
        }


