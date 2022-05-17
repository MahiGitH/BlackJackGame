package blackJack.java.file;

public enum Suit {
    CLUB("♣"),
    DIAMOND("♦"),
    HEART("♥"),
    SPADE("♠");

    final String suitName;

    private Suit(String suitName) {
        this.suitName = suitName;
    }

    public String toString() {
        return this.suitName;

    }
}
