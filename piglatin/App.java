package piglatin;

public class App {
    public static void main(String[] args) throws Exception {

        int score = TestSuite.run();
        if (score > 4) {
            Book input = new Book();
            input.readFromUrl("Pride and Prejudice",
                 "https://www.gutenberg.org/cache/epub/1342/pg1342.txt");

            Book output = PigLatinTranslator.translate(input);
            output.writeToFile("pigLatinBook.txt");

            // show where the file landed
            System.out.println("File saved at: " +
                 new java.io.File("pigLatinBook.txt").getAbsolutePath());

            // peek at first 500 lines
            output.printlines(0, 500);
        }
    }
}