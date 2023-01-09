package pl.refactoring.chain.classes;


import java.util.List;

import pl.refactoring.chain.classes.card.Card;
import pl.refactoring.chain.classes.specs.FlushSpec;
import pl.refactoring.chain.classes.specs.FourOfAKindSpec;
import pl.refactoring.chain.classes.specs.FullHouseSpec;
import pl.refactoring.chain.classes.specs.HighCardSpec;
import pl.refactoring.chain.classes.specs.OnePairSpec;
import pl.refactoring.chain.classes.specs.PokerHandSpec;
import pl.refactoring.chain.classes.specs.StraightFlushSpec;
import pl.refactoring.chain.classes.specs.StraightSpec;
import pl.refactoring.chain.classes.specs.ThreeOfAKindSpec;
import pl.refactoring.chain.classes.specs.TwoPairsSpec;

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
    private static final PokerHandSpec HIGH_CARD_SPEC = new HighCardSpec();
    private final PokerHandSpec onePairSpec = new OnePairSpec();
    private final PokerHandSpec twoPairsSpec = new TwoPairsSpec();
    private final PokerHandSpec threeOfAKindSpec = new ThreeOfAKindSpec();
    private final PokerHandSpec fullHouseSpec = new FullHouseSpec();
    private final PokerHandSpec fourOfAKindSpec = new FourOfAKindSpec();
    private final PokerHandSpec straightSpec = new StraightSpec();
    private final PokerHandSpec flushSpec = new FlushSpec();
    private final PokerHandSpec straightFlushSpec = new StraightFlushSpec();

    public Hand hand(CardSet cardSet) {

        if (straightFlushSpec.isSatisfiedBy(cardSet)) {
            return new Hand(straightFlushSpec.getRanking(), handCards(cardSet));
        }

        if (flushSpec.isSatisfiedBy(cardSet)) {
            return new Hand(flushSpec.getRanking(), handCards(cardSet));
        }

        if (straightSpec.isSatisfiedBy(cardSet)) {
            return new Hand(straightSpec.getRanking(), handCards(cardSet));
        }

        if (fourOfAKindSpec.isSatisfiedBy(cardSet)) {
            return new Hand(fourOfAKindSpec.getRanking(), handCards(cardSet));
        }

        if (fullHouseSpec.isSatisfiedBy(cardSet)) {
            return new Hand(fullHouseSpec.getRanking(), handCards(cardSet));
        }

        if (threeOfAKindSpec.isSatisfiedBy(cardSet)) {
            return new Hand(threeOfAKindSpec.getRanking(), handCards(cardSet));
        }

        if (twoPairsSpec.isSatisfiedBy(cardSet)) {
            return new Hand(twoPairsSpec.getRanking(), handCards(cardSet));
        }

        if (onePairSpec.isSatisfiedBy(cardSet)) {
            return new Hand(onePairSpec.getRanking(), handCards(cardSet));
        }

        if (HIGH_CARD_SPEC.isSatisfiedBy(cardSet)) {
            return new Hand(HIGH_CARD_SPEC.getRanking(), handCards(cardSet));
        }

        throw new IllegalStateException("Poker Hand not recognized");
    }

    private List<Card> handCards(CardSet cardSet) {
        return cardSet.getSortedCards();
    }

}
