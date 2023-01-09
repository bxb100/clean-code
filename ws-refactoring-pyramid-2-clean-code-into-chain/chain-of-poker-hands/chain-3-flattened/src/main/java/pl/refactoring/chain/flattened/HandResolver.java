package pl.refactoring.chain.flattened;


import pl.refactoring.chain.flattened.card.Card;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static pl.refactoring.chain.flattened.RANKING.*;

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
    private final StraightFlushSpec straightFlushSpec = new StraightFlushSpec();

    public Hand hand(CardSet cardSet) {

        if (straightFlushSpec.isStraightFlush(cardSet)) {
            return new Hand(straightFlushSpec.getStraightFlush(), handCards(cardSet));
        }

        if (isFlush(cardSet)) {
            return new Hand(FLUSH, handCards(cardSet));
        }

        if (isStraight(cardSet)) {
            return new Hand(STRAIGHT, handCards(cardSet));
        }

        if (isFourOfAKind(cardSet)) {
            return new Hand(FOUR_OF_A_KIND, handCards(cardSet));
        }

        if (isFullHouse(cardSet)) {
            return new Hand(FULL_HOUSE, handCards(cardSet));
        }

        if (isThreeOfAKind(cardSet)) {
            return new Hand(THREE_OF_A_KIND, handCards(cardSet));
        }

        if (isTwoPairs(cardSet)) {
            return new Hand(TWO_PAIRS, handCards(cardSet));
        }

        if (isOnePair(cardSet)) {
            return new Hand(ONE_PAIR, handCards(cardSet));
        }

        if (isHighCard(cardSet)) {
            return new Hand(HIGH_CARD, handCards(cardSet));
        }

        throw new IllegalStateException("Poker Hand not recognized");
    }

    private boolean isHighCard(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                !cardSet.isSequential() &&
                cardSet.hasRankDiversity(5);
    }

    private boolean isOnePair(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(4);
    }

    private boolean isTwoPairs(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(3) &&
                cardSet.containsRankWithMultiplicity(2);
    }

    private boolean isThreeOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(3) &&
                cardSet.containsRankWithMultiplicity(3);
    }

    private boolean isFullHouse(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(3);
    }

    private boolean isFourOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4);
    }

    private boolean isStraight(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(5) &&
                cardSet.isSequential();
    }

    private boolean isFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && !cardSet.isSequential();
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
