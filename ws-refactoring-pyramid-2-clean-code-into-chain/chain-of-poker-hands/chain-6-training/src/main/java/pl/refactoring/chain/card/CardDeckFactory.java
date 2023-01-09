package pl.refactoring.chain.card;

import java.util.Set;
import java.util.TreeSet;

import static pl.refactoring.chain.card.Card.aCard;

/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * <p>
 * This code is exclusive property of Wlodek Krakowski
 * for usage of attendees of trainings that are conducted by Wlodek Krakowski.
 * <p>
 * This code may not be copied or used without
 * written consent of IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * <p>
 * If willing to do so, please contact the author.
 */
public class CardDeckFactory {
    public CardDeck createDeck(int numberOfCards) {

        if (numberOfCards != 54 && (numberOfCards % 4 != 0 ||
                numberOfCards < 4 ||
                numberOfCards > 52)) {
            throw new IllegalArgumentException("Number of Cards must be multiplier of 4 between 4 and 52");
        }
        boolean joinJoker = false;
        if (numberOfCards == 54) {
            numberOfCards = 52;
            joinJoker = true;
        }

        int numberOfRanks = numberOfCards / 4;

        Set<Card> cards = new TreeSet<>();

        for (SUIT suit : SUIT.normalPoker()) {
            for (int i = 0; i < numberOfRanks; i++) {
                cards.add(aCard(suit, RANK.values()[i]));
            }
        }
        if (joinJoker) {
            cards.add(aCard(SUIT.RED, RANK.JOKER));
            cards.add(aCard(SUIT.BLACK, RANK.JOKER));
        }

        return new CardDeck(cards);
    }
}
