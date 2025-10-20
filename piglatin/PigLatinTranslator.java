package piglatin;

public class PigLatinTranslator {

    /* ----------  translate whole book  ---------- */
    public static Book translate(Book input) {
        Book outBook = new Book();
        outBook.setTitle(input.getTitle() + " (Pig-Latin)");

        int lines = input.getLineCount();
        for (int i = 0; i < lines; i++) {
            String original = input.getLine(i);
            String pigLine  = translate(original);   // calls the String version below
            outBook.appendLine(pigLine);
        }
        return outBook;
    }

    /* ----------  translate one line  ---------- */
    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");
        if (input == null) return "";

        // split line into words on spaces
        String build = "";
        int start = 0;
        int len   = input.length();

        while (start < len) {
            // skip spaces
            while (start < len && input.charAt(start) == ' ') start++;
            if (start >= len) break;

            // find end of word
            int end = start;
            while (end < len && input.charAt(end) != ' ') end++;

            String word = input.substring(start, end);
            String pig  = translateWord(word);

            if (build.length() > 0) build = build + " ";
            build = build + pig;

            start = end;
        }
        return build;
    }

    /* ----------  translate single word  ---------- */
    private static String translateWord(String input) {
    if (input.length() == 0) return input;

    // 1. split punctuation tail
    int tailStart = input.length();
    while (tailStart > 0) {
        char c = input.charAt(tailStart - 1);
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) break;
        tailStart--;
    }
    String core = input.substring(0, tailStart);
    String punct = input.substring(tailStart);

    // 2. remember original cap positions
    boolean[] upper = new boolean[core.length()];
    for (int i = 0; i < core.length(); i++) {
        upper[i] = (core.charAt(i) >= 'A' && core.charAt(i) <= 'Z');
    }

    // 3. lower-case working copy
    core = core.toLowerCase();

    // 4. find first vowel
    int firstVowel = 0;
    while (firstVowel < core.length()) {
        char c = core.charAt(firstVowel);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') break;
        firstVowel++;
    }

    // 5. build pig-latin stem
    String pig;
    if (firstVowel == 0) {
        pig = core + "ay";
    } else {
        pig = core.substring(firstVowel) + core.substring(0, firstVowel) + "ay";
    }

    // 6. restore caps ONLY in positions that were originally capped
    String out = "";
    for (int i = 0; i < pig.length(); i++) {
        char c = pig.charAt(i);
        if (i < upper.length && upper[i]) {
            // make upper
            if (c >= 'a' && c <= 'z') c = (char)(c - 32);
        }
        out = out + c;
    }

    return out + punct;
}
}