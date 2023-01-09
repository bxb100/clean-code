package pl.refactoring.chain.classes;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import pl.refactoring.chain.classes.card.Card;
import pl.refactoring.chain.classes.card.RANK;
import pl.refactoring.chain.classes.card.SUIT;
import static java.util.stream.Collectors.groupingBy;

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
public class CardSet {

    private final List<Card> sortedCards;

    public CardSet(Card card1, Card card2, Card card3, Card card4, Card card5) {
        SortedSet<Card> sortedSet = new TreeSet<>();

        sortedSet.add(card1);
        sortedSet.add(card2);
        sortedSet.add(card3);
        sortedSet.add(card4);
        sortedSet.add(card5);

        sortedCards = sortedSet.stream()
                .collect(Collectors.toList());

    }

    public List<Card> getSortedCards() {
        return sortedCards;
    }

    public boolean isAllSameSuit() {
        SUIT suitCandidate = sortedCards.get(0).getSuit();
        return sortedCards.stream()
                .allMatch(card -> card.getSuit().equals(suitCandidate));
    }

    public boolean isSequential() {
        int firstOrdinal = sortedCards.get(0).getRank().ordinal();
        int secondOrdinal = sortedCards.get(1).getRank().ordinal();
        int thirdOrdinal = sortedCards.get(2).getRank().ordinal();
        int fourthOrdinal = sortedCards.get(3).getRank().ordinal();
        int fifthOrdinal = sortedCards.get(4).getRank().ordinal();

        return firstOrdinal + 1 == secondOrdinal
                && secondOrdinal + 1 == thirdOrdinal
                && thirdOrdinal + 1 == fourthOrdinal
                && fourthOrdinal + 1 == fifthOrdinal;
    }

    public boolean hasRankDiversity(int ranksDiversity) {
        return sortedCards.stream()
                .collect(groupingBy(Card::getRank)).size() == ranksDiversity;
    }

    public boolean containsRankWithMultiplicity(int expectedRankMultiplicity) {
        Map<RANK, List<Card>> cardsByRank = sortedCards.stream()
                .collect(groupingBy(Card::getRank));

        return cardsByRank.values().stream()
                .map(cards -> cards.size())
                .anyMatch(cardsWithSingleRank -> cardsWithSingleRank == expectedRankMultiplicity);
    }
}
