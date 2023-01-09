package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;
import static pl.refactoring.chain.classes.RANKING.STRAIGHT;

public class StraightSpec implements PokerHandSpec {
    public StraightSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(5) &&
                cardSet.isSequential();
    }

    public RANKING getRanking() {
        return STRAIGHT;
    }
}