package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;
import static pl.refactoring.chain.classes.RANKING.TWO_PAIRS;

public class TwoPairsSpec implements PokerHandSpec {
    public TwoPairsSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(3) &&
                cardSet.containsRankWithMultiplicity(2);
    }

    public RANKING getRanking() {
        return TWO_PAIRS;
    }
}