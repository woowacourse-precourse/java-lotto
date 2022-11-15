package common.regulation;

import domain.Rank;

public enum RankRule {

    RANK_1_BONUS(false),
    RANK_2_BONUS(true),
    RANK_3_BONUS(false),
    RANK_4_BONUS(false),
    RANK_5_BONUS(false),
    RANK_1_match(6),
    RANK_2_match(5),
    RANK_3_match(5),
    RANK_4_match(4),
    RANK_5_match(3),
    RANK_1_REWARD(2000000000l),
    RANK_2_REWARD(30000000l),
    RANK_3_REWARD(1500000l),
    RANK_4_REWARD(50000l),
    RANK_5_REWARD(5000l);

    private boolean bonus;
    private int match;
    private long reward;

    RankRule(int match) {
        this.match = match;
    }

    RankRule(boolean bonus) {
        this.bonus = bonus;
    }

    RankRule(long reward) {
        this.reward = reward;
    }

    public boolean getBonus() {
        return bonus;
    }

    public int getMatch() {
        return match;
    }

    public long getReward() {
        return reward;
    }
}
