import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void add(Card c) {
        cards.add(c);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getValue() {
        int sum = 0;
        int aceCount = 0;

        for (int i = 0; i < cards.size(); i++) {
            Card c = cards.get(i);
            sum = sum + c.getValue();

            if (c.isAce()) {
                aceCount = aceCount + 1;
            }
        }

        for (int i = 0; i < aceCount; i++) {
            if (sum + 10 <= 21) {
                sum = sum + 10;
            }
        }

        return sum;
    }

    public boolean isBust() {
        return getValue() > 21;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && getValue() == 21;
    }

    public void clear() {
        cards.clear();
    }

    public String toString() {
        String text = "";

        for (int i = 0; i < cards.size(); i++) {
            text = text + cards.get(i);

            if (i < cards.size() - 1) {
                text = text + ", ";
            }
        }

        return "[" + text + "] (value: " + getValue() + ")";
    }
}
