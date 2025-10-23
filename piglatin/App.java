package piglatin;

public class App {
    public static void main(String[] args) throws Exception {   // <- added throws

        // Run tests; comment out once they pass.
        int score = TestSuite.run();
        if (score > 4) {
            Book input = new Book();

            // 1. load Romeo & Juliet from Project Gutenberg
            input.readFromUrl("Romeo and Juliet",
                 "https://gutenberg.pglaf.org/cache/epub/1513/pg1513.txt");

            // 2. translate entire book
            Book output = PigLatinTranslator.translate(input);

            // 3. save translated text
            output.writeToFile("pigLatinBook.txt");

            // 4. (optional) show first few lines
            output.printlines(0, 500);
        }
    }
}