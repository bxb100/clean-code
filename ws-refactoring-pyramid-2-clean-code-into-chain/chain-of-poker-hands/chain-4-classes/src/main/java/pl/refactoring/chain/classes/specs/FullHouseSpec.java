package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;
import static pl.refactoring.chain.classes.RANKING.FULL_HOUSE;

public class FullHouseSpec implements PokerHandSpec {
    public FullHouseSpec() {
    }

     public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(3);
    }

    public RANKING getRanking() {
        return FULL_HOUSE;
    }
}