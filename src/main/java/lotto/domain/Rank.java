package lotto.domain;

import java.util.*;

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

    public static List<Rank> asSortedList() {
        List<Rank> ranks = new ArrayList<>(List.of(Rank.values()));
        sort(ranks);
        return ranks;
    }

    private static void sort(List<Rank> ranks){
        Collections.sort(ranks, (rank1, rank2) -> {
            if (rank1.getMatchedCount() == rank2.getMatchedCount()) {
                return rank1.getBonusCount().compareTo(rank2.getBonusCount());
            }
            return rank1.getMatchedCount().compareTo(rank2.getMatchedCount());
        });


    }

}
