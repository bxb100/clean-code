package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;
import static pl.refactoring.chain.classes.RANKING.STRAIGHT_FLUSH;

public class StraightFlushSpec implements PokerHandSpec {
    public StraightFlushSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return cardSet.isAllSameSuit() && cardSet.isSequential();
    }

    public RANKING getRanking() {
        return STRAIGHT_FLUSH;
    }
}