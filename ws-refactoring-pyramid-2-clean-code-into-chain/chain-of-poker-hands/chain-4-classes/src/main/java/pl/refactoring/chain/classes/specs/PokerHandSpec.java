package pl.refactoring.chain.classes.specs;

import pl.refactoring.chain.classes.CardSet;
import pl.refactoring.chain.classes.RANKING;

public interface PokerHandSpec {
    boolean isSatisfiedBy(CardSet cardSet);

    RANKING getRanking();
}
