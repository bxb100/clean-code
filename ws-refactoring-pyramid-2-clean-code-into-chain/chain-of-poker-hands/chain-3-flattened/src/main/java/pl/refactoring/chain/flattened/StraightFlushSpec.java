package pl.refactoring.chain.flattened;

import static pl.refactoring.chain.flattened.RANKING.STRAIGHT_FLUSH;

public class StraightFlushSpec {
    public StraightFlushSpec() {
    }

    boolean isStraightFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && cardSet.isSequential();
    }

    RANKING getStraightFlush() {
        return STRAIGHT_FLUSH;
    }
}