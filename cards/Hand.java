package cards;

public class Hand {
    private Card[] cards;
    private int size;

    public Hand(int maxSize) {
        cards = new Card[maxSize];
        size = 0;
    }

    public void add(Card c) {
        if (size < cards.length) {
            cards[size] = c;
            size++;
        }
    }

    public int length() {
        return size;
    }

    public Card get(int index) {
        if (index >= 0 && index < size) {
            return cards[index];
        }
        return null;
    }

    public Card remove(int index) {
        if (index < 0 || index >= size) return null;

        Card removed = cards[index];

        // shift left
        for (int i = index; i < size - 1; i++) {
            cards[i] = cards[i + 1];
        }

        // clean up last slot
        cards[size - 1] = null;

        size--;  
        return removed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < size; i++) {
            sb.append(cards[i]); // relies on Card.toString()
            if (i < size - 1) sb.append(" ");
        }

        return sb.toString();
    }
}
