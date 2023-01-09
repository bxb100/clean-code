package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;
import static pl.refactoring.chain.classes.RANKING.ONE_PAIR;

public class OnePairSpec implements PokerHandSpec {
    public OnePairSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(4);
    }

    public RANKING getRanking() {
        return ONE_PAIR;
    }
}