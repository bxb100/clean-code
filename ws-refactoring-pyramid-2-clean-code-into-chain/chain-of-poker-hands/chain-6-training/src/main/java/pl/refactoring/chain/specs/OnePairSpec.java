package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.ONE_PAIR;

public class OnePairSpec {
    public OnePairSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(4);
    }

    public RANKING getOnePairRanking() {
        return ONE_PAIR;
    }
}