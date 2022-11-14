package lotto.calculation;

import java.util.HashMap;

public enum Rank {
    RANK_FIVE("3개 일치 (5,000원)", 5000L),
    RANK_FOUR("4개 일치 (50,000원", 50000L),
    RANK_THREE("5개 일치 (1,500,000원", 1500000L),
    RANK_TWO("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000L),
    RANK_ONE("6개 일치 (2,000,000,000원", 2000000000L);

    private String title;
    private long reward;
    Rank(String title, long reward) {
        this.title = title;
        this.reward = reward;
    }

    public String getTitle() {
        return title;
    }

    public HashMap<Rank, Integer> getRank() {
        HashMap<Rank, Integer> rankInfo = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankInfo.put(rank, 0);
        }
        return rankInfo;
    }
}
