package pl.refactoring.chain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pl.refactoring.chain.card.Card;
import pl.refactoring.chain.card.RANK;
import static java.util.stream.Collectors.groupingBy;
import static pl.refactoring.chain.RANKING.FLUSH;
import static pl.refactoring.chain.RANKING.FOUR_OF_A_KIND;
import static pl.refactoring.chain.RANKING.FULL_HOUSE;
import static pl.refactoring.chain.RANKING.HIGH_CARD;
import static pl.refactoring.chain.RANKING.ONE_PAIR;
import static pl.refactoring.chain.RANKING.STRAIGHT;
import static pl.refactoring.chain.RANKING.STRAIGHT_FLUSH;
import static pl.refactoring.chain.RANKING.THREE_OF_A_KIND;
import static pl.refactoring.chain.RANKING.TWO_PAIRS;

/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * <p>
 * This code is exclusive property of Wlodek Krakowski
 * for usage of attendees of trainings that are conducted by Wlodek Krakowski.
 * <p>
 * This code may not be copied or used without
 * written consent of IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * <p>
 * If willing to do so, please contact the author.
 */
public class HandResolver {
    public Hand hand(CardSet cardSet) {

        if (cardSet.isAllSameSuit() && cardSet.isSequential())
            return new Hand(STRAIGHT_FLUSH, cardSet.getSortedCards());
        if (cardSet.isAllSameSuit() && !cardSet.isSequential())
            return new Hand(FLUSH, cardSet.getSortedCards());

        // else removed
        // TODO: Below logic assumed that cards belong to different suites

        {
            // Check for possible x of a kind
            Map<RANK, List<Card>> cardsByRank = cardSet.getSortedCards().stream().collect(groupingBy(Card::getRank));

            List<RANK> ranks = new ArrayList<>(cardsByRank.keySet());
            if (ranks.size() == 5) {
                // Check for straight
                boolean isSequential = cardSet.isSequential();
                if (isSequential)
                    return new Hand(STRAIGHT, cardSet.getSortedCards());
            }
            if (ranks.size() == 2) {
                // Look for four of a kind
                if (cardsByRank.get(ranks.get(0)).size() == 4 ||
                        cardsByRank.get(ranks.get(1)).size() == 4)
                    return new Hand(FOUR_OF_A_KIND, cardSet.getSortedCards());
                    // Look for full house
                else {
                    return new Hand(FULL_HOUSE, cardSet.getSortedCards());
                }
            } else if (ranks.size() == 3) {
                // Look for 3 of a kind
                if (cardsByRank.get(ranks.get(0)).size() == 3 ||
                        cardsByRank.get(ranks.get(1)).size() == 3 ||
                        cardsByRank.get(ranks.get(2)).size() == 3)
                    return new Hand(THREE_OF_A_KIND, cardSet.getSortedCards());

                // Look for 2 pairs
                if (cardsByRank.get(ranks.get(0)).size() == 1 ||
                        cardsByRank.get(ranks.get(1)).size() == 1 ||
                        cardsByRank.get(ranks.get(2)).size() == 1)
                    return new Hand(TWO_PAIRS, cardSet.getSortedCards());
            } else if (ranks.size() == 4) {
                return new Hand(ONE_PAIR, cardSet.getSortedCards());
            } else {
                return new Hand(HIGH_CARD, cardSet.getSortedCards());
            }
        }

        return new Hand(HIGH_CARD, cardSet.getSortedCards());
    }

}
