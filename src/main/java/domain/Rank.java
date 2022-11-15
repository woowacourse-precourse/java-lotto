package domain;

import common.message.Message;
import common.regulation.RankRule;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Rank {

    private int ranking;
    private int match;
    private long reward;
    private boolean bonus;
    private int count = 0;

    public Rank(int ranking, int match, long reward, boolean bonus) {
        this.ranking = ranking;
        this.match = match;
        this.reward = reward;
        this.bonus = bonus;
    }

    public static List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(new Rank(5, RankRule.RANK_5_match.getMatch(),
                RankRule.RANK_5_REWARD.getReward(), RankRule.RANK_5_BONUS.getBonus()));
        ranks.add(new Rank(4, RankRule.RANK_4_match.getMatch(),
                RankRule.RANK_4_REWARD.getReward(), RankRule.RANK_4_BONUS.getBonus()));
        ranks.add(new Rank(3, RankRule.RANK_3_match.getMatch(),
                RankRule.RANK_3_REWARD.getReward(), RankRule.RANK_3_BONUS.getBonus()));
        ranks.add(new Rank(2, RankRule.RANK_2_match.getMatch(),
                RankRule.RANK_2_REWARD.getReward(), RankRule.RANK_2_BONUS.getBonus()));
        ranks.add(new Rank(1, RankRule.RANK_1_match.getMatch(),
                RankRule.RANK_1_REWARD.getReward(), RankRule.RANK_1_BONUS.getBonus()));

        return ranks;
    }

    public boolean isBonus() {
        if (bonus) return true;
        return false;
    }

    public int getRanking() {
        return ranking;
    }

    public int getMatch() {
        return match;
    }

    public long getReward() {
        return reward;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    public long getTotalReward() {
        return (reward * count);
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public void setReward(long reward) {
        this.reward = reward;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(match).append(Message.RESULT_A.getValue());
        if (bonus) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append(" " + Message.BRACKET_LEFT.getValue())
                .append(NumberFormat.getInstance().format(getReward()))
                .append(Message.WON.getValue())
                .append(Message.BRACKET_RIGHT.getValue())
                .append(Message.SLASH.getValue())
                .append(getCount())
                .append(Message.EA.getValue()).append('\n');

        return sb.toString();
    }
}
