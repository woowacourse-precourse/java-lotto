package lotto.data;

import java.util.List;

public enum LottoRank {
    FIRST(1, "6개 일치", 2_000_000_000L),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30_000_000L),
    THIRD(3, "5개 일치", 1_500_000L),
    FOURTH(4, "4개 일치", 50_000L),
    FIFTH(5, "3개 일치", 5_000L);

    private final int rank;
    private final String condition;
    private final long reward;

    LottoRank(int rank, String condition, long reward) {
        this.rank = rank;
        this.condition = condition;
        this.reward = reward;
    }

    public int getRank() {
        return rank;
    }

    public String getCondition() {
        return condition;
    }

    public long getReward() {
        return reward;
    }

    public void printLottoRankWithAmount(int winningAmount) {
        String message = condition + " (" + getStringReward(reward) + ")" + " - " + winningAmount + "개";
        System.out.println(message);
    }

    private String getStringReward(long reward) {
        StringBuilder rewardBuilder = new StringBuilder();
        int count = 0;

        while(reward > 0) {
            long digit = reward % 10;
            rewardBuilder.insert(0, digit);

            count++;
            reward /= 10;

            if (count == 3) {
                rewardBuilder.insert(0, ",");
                count = 0;
            }
        }

        rewardBuilder.append("원");
        return rewardBuilder.toString();
    }

    public static LottoRank getLottoRankByWinningCountAndBonus(int winningCount, boolean isSameWithBonus) {
        if (winningCount == 6) {
            return FIRST;
        } else if (winningCount == 5 && isSameWithBonus) {
            return SECOND;
        } else if (winningCount == 5) {
            return THIRD;
        } else if (winningCount == 4) {
            return FOURTH;
        } else if (winningCount == 3) {
            return FIFTH;
        }

        return FIFTH;
    }

    public static List<LottoRank> getLottoRanks() {
        return List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH);
    }

    public static List<LottoRank> getLottoRanksDesc() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }
}
