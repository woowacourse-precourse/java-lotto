package lotto.model;

import lotto.constants.RankMessage;

import static lotto.constants.RankMessage.*;

public enum Rank {

    fifth(FIFTH, FIFTH_PRICE),
    fourth(FOURTH, FOURTH_PRICE),
    third(THIRD, THIRD_PRICE),
    second(SECOND,SECOND_PRICE),
    first(FIRST,FIRST_PRICE);

    final private String matchMessage;
    final private Integer matchMoney;

    public Integer getMatchMoney() {
        return matchMoney;
    }

    public String getMatchMessage() {
        return matchMessage;
    }

    Rank(String matchMessage, Integer matchMoney) {
        this.matchMessage = matchMessage;
        this.matchMoney = matchMoney;
    }
}
