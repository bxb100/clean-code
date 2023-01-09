package pl.refactoring.chain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import pl.refactoring.chain.card.Card;
import pl.refactoring.chain.card.RANK;
import pl.refactoring.chain.card.SUIT;
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

        sortedCards = new ArrayList<>(sortedSet);

    }

    public List<Card> getSortedCards() {
        return sortedCards;
    }

    public boolean isAllSameSuit() {
        SUIT suitCandidate = sortedCards.get(0).getSuit();
        return sortedCards.stream()
                .allMatch(card -> card.getSuit().equals(suitCandidate) || card.getRank() == RANK.JOKER);
    }

    public boolean isSequential() {
        // Check for straight
        int firstOrdinal = sortedCards.get(0).getRank().ordinal();
        int secondOrdinal = sortedCards.get(1).getRank().ordinal();
        int thirdOrdinal = sortedCards.get(2).getRank().ordinal();
        int fourthOrdinal = sortedCards.get(3).getRank().ordinal();
        int fifthOrdinal = sortedCards.get(4).getRank().ordinal();

        return (firstOrdinal + 1 == secondOrdinal || sortedCards.get(0).getRank() == RANK.JOKER)
                && (secondOrdinal + 1 == thirdOrdinal || sortedCards.get(1).getRank() == RANK.JOKER)
                && (thirdOrdinal + 1 == fourthOrdinal || sortedCards.get(2).getRank() == RANK.JOKER)
                && (fourthOrdinal + 1 == fifthOrdinal || sortedCards.get(3).getRank() == RANK.JOKER);
    }

    public boolean hasRankDiversity(int rankDiversity) {
        long jokerNums = sortedCards.stream().filter(card -> card.getRank() == RANK.JOKER).count();
        Map<RANK, List<Card>> cardRankMap = sortedCards.stream()
                .collect(groupingBy(Card::getRank));
        return Math.min(cardRankMap.size() - jokerNums, cardRankMap.size()) == rankDiversity;
    }

    public boolean containsRankWithMultiplicity(int expectedRankMultiplicity) {

        long jokerNums = sortedCards.stream().filter(card -> card.getRank() == RANK.JOKER).count();

        Map<RANK, List<Card>> cardsByRank = getSortedCards().stream()
                .collect(groupingBy(Card::getRank));

        return cardsByRank.values().stream()
                .map(cards -> cards.size())
                .anyMatch(cardWithSingleRank -> cardWithSingleRank == expectedRankMultiplicity);
    }
}
