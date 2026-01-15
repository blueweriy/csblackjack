public class Card {

    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getValue() {
        if (rank.equals("A")) {
            return 1;
        }

        if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
            return 10;
        }

        return Integer.parseInt(rank);
    }

    public boolean isAce() {
        return rank.equals("A");
    }

    public String toString() {
        return rank + suit;
    }
}
