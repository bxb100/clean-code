package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;
import static pl.refactoring.chain.classes.RANKING.FOUR_OF_A_KIND;

public class FourOfAKindSpec implements PokerHandSpec {
    public FourOfAKindSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4);
    }

    public RANKING getRanking() {
        return FOUR_OF_A_KIND;
    }
}