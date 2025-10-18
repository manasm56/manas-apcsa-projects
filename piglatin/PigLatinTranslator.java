package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
    Book translatedBook = new Book();
    translatedBook.setTitle(input.getTitle() + " (Pig-Latin)");
    for (int i = 0; i < input.getLineCount(); i++) {
        translatedBook.appendLine(translate(input.getLine(i)));
    }
    return translatedBook;
}

    public static String translate(String input) {
    System.out.println("  -> translate('" + input + "')");
    if (input == null) return "";
    String[] words = input.split(" ");
    for (int i = 0; i < words.length; i++) words[i] = translateWord(words[i]);
    return String.join(" ", words);
}

    private static String translateWord(String input) {
    if (input.isEmpty()) return input;

    // 1. punctuation tail
    int cut = input.length();
    while (cut > 0 && !Character.isLetterOrDigit(input.charAt(cut - 1))) cut--;
    String core = input.substring(0, cut), tail = input.substring(cut);

    // 2. remember original cap positions
    boolean[] up = new boolean[core.length()];
    for (int i = 0; i < core.length(); i++) up[i] = Character.isUpperCase(core.charAt(i));

    // 3. lower-case working copy
    core = core.toLowerCase();

    // 4. rotate to first vowel
    int v = 0;
    while (v < core.length() && !"aeiou".contains(String.valueOf(core.charAt(v)))) v++;
    String pig = (v == 0 ? core : core.substring(v) + core.substring(0, v)) + "ay";

    // 5. restore caps ONLY in positions that were originally capped
    StringBuilder out = new StringBuilder(pig);
    for (int i = 0; i < up.length && i < out.length(); i++)
        if (up[i]) out.setCharAt(i, Character.toUpperCase(out.charAt(i)));

    return out.toString() + tail;
}

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
