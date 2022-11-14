package lotto.util;

import java.util.Arrays;

public enum MatchMoney {
    THREE(3,5_000, false),
    FOUR(4,5_0000,false),
    FIVE(5,1_500_000,false),
    FIVE_BONUS(5,30_000_000,true),
    SIX(6,2_000_000_000,false);

    private int matchNumber;
    private int price;
    private boolean bonus;

    MatchMoney(int matchNumber, int price, boolean bonus){
        this.matchNumber = matchNumber;
        this.price = price;
        this.bonus = bonus;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrice() {
        return price;
    }

    public boolean getBonus() {
        return bonus;
    }

    public static MatchMoney of(int match, boolean bonus){
        return Arrays.stream(MatchMoney.values()).filter(x -> x.matchNumber == match)
                .filter(x -> x.bonus == bonus).findFirst().orElse(null);
    }
}
