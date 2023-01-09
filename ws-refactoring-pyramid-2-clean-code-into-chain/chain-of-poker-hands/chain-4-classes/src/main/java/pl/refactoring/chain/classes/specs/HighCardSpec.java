package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;
import static pl.refactoring.chain.classes.RANKING.HIGH_CARD;

public class HighCardSpec implements PokerHandSpec {
    public HighCardSpec() {
    }

    @Override
    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                !cardSet.isSequential() &&
                cardSet.hasRankDiversity(5);
    }

    @Override
    public RANKING getRanking() {
        return HIGH_CARD;
    }
}