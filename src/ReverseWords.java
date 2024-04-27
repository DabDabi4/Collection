public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = reverseString(words[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
