package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {

    /* ----------  translate whole book  ---------- */
    public static Book translate(Book input) {
        Book outBook = new Book();
        outBook.setTitle(input.getTitle() + " (Pig-Latin)");

        int lines = input.getLineCount();
        for (int i = 0; i < lines; i++) {
            String original = input.getLine(i);
            String pigLine  = translate(original);
            outBook.appendLine(pigLine);
        }
        return outBook;
    }

    /* ----------  translate one line  ---------- */
    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");
        if (input == null) return "";

        String build = "";
        Scanner sc = new Scanner(input);   // NEW: use Scanner to split on spaces
        while (sc.hasNext()) {
            String word = sc.next();
            String pig  = translateWord(word);
            if (!build.equals("")) build = build + " ";
            build = build + pig;
        }
        sc.close();
        return build;
    }

    /* ----------  translate single word  ---------- */
    private static String translateWord(String input) {
        if (input.length() == 0) return input;

        // 1. split punctuation tail
        int tailStart = input.length();
        while (tailStart > 0) {
            String c = input.substring(tailStart - 1, tailStart);
            if ((c.compareTo("A") >= 0 && c.compareTo("Z") <= 0) ||
                (c.compareTo("a") >= 0 && c.compareTo("z") <= 0)) break;
            tailStart--;
        }
        String core = input.substring(0, tailStart);
        String punct = input.substring(tailStart);

        // 2. remember original cap positions
        boolean[] upper = new boolean[core.length()];
        for (int i = 0; i < core.length(); i++) {
            String let = core.substring(i, i + 1);
            upper[i] = (let.compareTo("A") >= 0 && let.compareTo("Z") <= 0);
        }

        // 3. lower-case working copy
        core = core.toLowerCase();

        // 4. find first vowel
        int firstVowel = 0;
        while (firstVowel < core.length()) {
            String c = core.substring(firstVowel, firstVowel + 1);
            if (c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u")) break;
            firstVowel++;
        }

        // 5. build pig-latin stem
        String pig;
        if (firstVowel == 0) {
            pig = core + "ay";
        } else {
            pig = core.substring(firstVowel);
            int index = pig.length();
            pig = pig + core.substring(0, firstVowel) + "ay";

            //Update upper cap positions to add exception for cluster moved to end.
            for(int i=index; i < index+firstVowel; i++) {
                upper[i] = false;
            }
        }

        // 6. restore original capitals in same positions
        String out = "";
        for (int i = 0; i < pig.length(); i++) {
            String c = pig.substring(i, i + 1);
            if (i < upper.length && upper[i]) {
                if (c.compareTo("a") >= 0 && c.compareTo("z") <= 0)
                    c = String.valueOf((char)(c.charAt(0) - 32));
            }
            out = out + c;
        }

        return out + punct;
    }
}