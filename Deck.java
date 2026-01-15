import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        for (int s = 0; s < 4; s++) {
            String suit = "";

            if (s == 0) suit = "♠";
            if (s == 1) suit = "♥";
            if (s == 2) suit = "♦";
            if (s == 3) suit = "♣";

            for (int r = 2; r <= 10; r++) {
                cards.add(new Card(String.valueOf(r), suit));
            }

            cards.add(new Card("J", suit));
            cards.add(new Card("Q", suit));
            cards.add(new Card("K", suit));
            cards.add(new Card("A", suit));
        }
    }

    public Card draw() {
        if (cards.size() == 0) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
}
