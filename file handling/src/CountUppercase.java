public class CountUppercase {
    // Recursive method to count uppercase 'E'
    public static int countE(String str) {
        // Base case if the string is empty, return 0
        if (str.isEmpty()) {
            return 0;
        }
        // Check the first character and count if 'E'
        int count = (str.charAt(0) == 'E') ? 1 : 0;
        // Recursive call for the rest of the string
        return count + countE(str.substring(1));
    }
    public static void main(String[] args) {
        String inputString = "Hello Everyone! Enjoy the Experience.";
        System.out.println("Count of 'E': " + countE(inputString));
    }

}
