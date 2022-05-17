package blackJack.java.file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cardDeck = new ArrayList();

    public Deck() {
    }

    public void createFullDeck() {
        Suit[] var1 = Suit.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Suit cardSuit = var1[var3];
            Value[] var5 = Value.values();
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                Value cardValue = var5[var7];
                this.cardDeck.add(new Card(cardSuit, cardValue));
            }
        }

    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardDeck, new Random());
    }

    public void addCard(Card card) {
        this.cardDeck.add(card);
    }

    public void removeCard(int i) {
        this.cardDeck.remove(i);
    }

    public Card getCard(int i) {
        return (Card)this.cardDeck.get(i);
    }

    public void draw(Deck comingFrom) {
        this.cardDeck.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    public int deckSize() {
        return this.cardDeck.size();
    }

    public void moveAllToDeck(Deck moveTo) {
        int thisDeckSize = this.cardDeck.size();

        int i;
        for(i = 0; i < thisDeckSize; ++i) {
            moveTo.addCard(this.getCard(i));
        }

        for(i = 0; i < thisDeckSize; ++i) {
            this.removeCard(0);
        }

    }

    public int cardValue() {
        int totalValue = 0;
        int aceCount = 0;
        Iterator var3 = this.cardDeck.iterator();

        while(var3.hasNext()) {
            Card cardInDeck = (Card)var3.next();
            switch (cardInDeck.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    ++aceCount;
            }
        }

        for(int i = 0; i < aceCount; ++i) {
            if (totalValue > 10) {
                ++totalValue;
            } else {
                totalValue += 11;
            }
        }

        return totalValue;
    }

    public String toString() {
        String cardInDeck = "";

        Card card;
        for(Iterator var2 = this.cardDeck.iterator(); var2.hasNext(); cardInDeck = cardInDeck + " " + card.toString()) {
            card = (Card)var2.next();
        }

        return cardInDeck;
    }
}
