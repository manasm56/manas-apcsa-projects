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
    System.out.println("  -> translateWord('" + input + "')");
    if (input.isEmpty()) return input;

    // 1. split punctuation tail
    int i = input.length();
    while (i > 0 && !Character.isLetterOrDigit(input.charAt(i - 1))) i--;
    String stem = input.substring(0, i);
    String punct = input.substring(i);

    // 2. remember original capital positions
    boolean[] upper = new boolean[stem.length()];
    for (int k = 0; k < stem.length(); k++) upper[k] = Character.isUpperCase(stem.charAt(k));
    stem = stem.toLowerCase();

    // 3. find first vowel
    int v = 0;
    while (v < stem.length() && !"aeiou".contains(stem.substring(v, v + 1))) v++;

    // 4. build pig-latin stem
    String pig = (v == 0 ? stem : stem.substring(v) + stem.substring(0, v)) + "ay";

    // 5. restore original capital pattern
    StringBuilder out = new StringBuilder(pig);
    for (int k = 0; k < upper.length && k < out.length(); k++) {
        if (upper[k]) out.setCharAt(k, Character.toUpperCase(out.charAt(k)));
    }

    return out.toString() + punct;
}

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
