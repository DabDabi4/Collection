public class ReverseWords {
    public static String reverseWords(String s) {
        // Розділяємо вхідний рядок на слова
        String[] words = s.split(" ");

        // Проходимося по кожному слову і перевертаємо його, якщо воно має 5 або більше символів
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = reverseString(words[i]);
            }
        }

        // Збираємо слова назад у рядок з пробілами
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    // Функція для перевертання рядка
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
