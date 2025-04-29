package Testdriven3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckGenerator {

    public static List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String value : values) {
                deck.add(new Card(suit, value));
            }
        }
        return deck;
    }

    public static void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    public static Card drawCard(List<Card> deck) {
        if (deck.isEmpty()) {
            return null; // Alternativ: throw new IllegalStateException("Deck is empty");
        }
        return deck.remove(0); // Tar första kortet (överst)
    }
}
