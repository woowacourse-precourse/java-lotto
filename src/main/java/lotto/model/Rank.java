package lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    NONE(0, 0, 0);

    private Integer matchedCount;
    private Integer bonusCount;
    private Integer amount;

    Rank(Integer matchedCount, Integer bonusCount, Integer amount){
        this.matchedCount = matchedCount;
        this.bonusCount = bonusCount;
        this.amount = amount;

    }

    public Integer getMatchedCount() {
        return matchedCount;
    }

    public Integer getBonusCount() {
        return bonusCount;
    }

    public Integer getAmount() {
        return amount;
    }


}
