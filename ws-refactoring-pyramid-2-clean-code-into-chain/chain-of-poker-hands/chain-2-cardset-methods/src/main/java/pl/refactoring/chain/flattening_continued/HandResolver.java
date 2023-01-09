package pl.refactoring.chain.flattening_continued;

import java.util.List;

import pl.refactoring.chain.flattening_continued.card.Card;
import static pl.refactoring.chain.flattening_continued.RANKING.FLUSH;
import static pl.refactoring.chain.flattening_continued.RANKING.FOUR_OF_A_KIND;
import static pl.refactoring.chain.flattening_continued.RANKING.FULL_HOUSE;
import static pl.refactoring.chain.flattening_continued.RANKING.HIGH_CARD;
import static pl.refactoring.chain.flattening_continued.RANKING.ONE_PAIR;
import static pl.refactoring.chain.flattening_continued.RANKING.STRAIGHT;
import static pl.refactoring.chain.flattening_continued.RANKING.STRAIGHT_FLUSH;
import static pl.refactoring.chain.flattening_continued.RANKING.THREE_OF_A_KIND;
import static pl.refactoring.chain.flattening_continued.RANKING.TWO_PAIRS;

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
public class HandResolver {
    public Hand hand(CardSet cardSet) {

        if (cardSet.isAllSameSuit() && cardSet.isSequential()) {
            return new Hand(STRAIGHT_FLUSH, handCards(cardSet));
        }

        if (cardSet.isAllSameSuit() && !cardSet.isSequential()) {
            return new Hand(FLUSH, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(5) &&
                cardSet.isSequential()) {
            return new Hand(STRAIGHT, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4)) {
            return new Hand(FOUR_OF_A_KIND, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(3)) {
            return new Hand(FULL_HOUSE, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(3) &&
                cardSet.containsRankWithMultiplicity(3))
            return new Hand(THREE_OF_A_KIND, handCards(cardSet));

        if (!cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(3) &&
                cardSet.containsRankWithMultiplicity(2)) {
            return new Hand(TWO_PAIRS, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit() && cardSet.hasRankDiversity(4)) {
            return new Hand(ONE_PAIR, handCards(cardSet));
        }

        if (!cardSet.isAllSameSuit() && cardSet.hasRankDiversity(5)) {
            return new Hand(HIGH_CARD, handCards(cardSet));
        }

        throw new IllegalStateException("Poker hand not recognized");
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
