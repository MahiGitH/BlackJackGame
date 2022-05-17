package blackJack.java.file;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Card(Card card) {
        this.suit = card.getSuit();
        this.value = card.getValue();
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Value getValue() {
        return this.value;
    }

    public String toString() {
        String var10000 = this.suit.toString();
        return var10000 + this.value.toString();
    }
}
