package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;
import static pl.refactoring.chain.classes.RANKING.THREE_OF_A_KIND;

public class ThreeOfAKindSpec implements PokerHandSpec {
    public ThreeOfAKindSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(3) &&
                cardSet.containsRankWithMultiplicity(3);
    }

    public RANKING getRanking() {
        return THREE_OF_A_KIND;
    }
}