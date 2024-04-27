
public class Main {

        public static void main(String[] args) {
                int smallSize = 50000;
                int mediumSize = 500000;
                int largeSize = 1000000;

                TesterCollection tester = new TesterCollection();

                // Тестування для 50 тис. елементів
                System.out.println("Тест на 50тис. елементів");
                tester.runTests(smallSize);
                System.out.println("_____________________________");

                // Тестування для 500 тис. елементів
                System.out.println("Тест на 500тис. елементів");
                tester.runTests(mediumSize);
                System.out.println("_____________________________");

                // Тестування для 1 мільйона елементів
                System.out.println("Тест на 1млн. елементів");
                tester.runTests(largeSize);
                System.out.println("_____________________________");

                System.out.println("Hello world from OpenAI");
                String input = "Hello world from OpenAI";
                String result = ReverseWords.reverseWords(input);
                System.out.println(result);
        }
}
