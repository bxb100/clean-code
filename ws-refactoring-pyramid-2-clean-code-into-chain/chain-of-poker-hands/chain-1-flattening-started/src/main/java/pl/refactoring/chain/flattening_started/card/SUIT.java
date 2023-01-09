package pl.refactoring.chain.flattening_started.card;

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
public enum SUIT {
    HEART("❤"),
    DIAMOND("♦"),
    CLUB("♣"),
    SPADE("♠");

    private final String symbol;

    SUIT(String symbol) {
        this.symbol = symbol;
    }

    public String getChar() {
        return symbol;
    }
}
