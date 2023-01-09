package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;
import static pl.refactoring.chain.classes.RANKING.FLUSH;

public class FlushSpec implements PokerHandSpec {
    public FlushSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return cardSet.isAllSameSuit() && !cardSet.isSequential();
    }

    public RANKING getRanking() {
        return FLUSH;
    }
}