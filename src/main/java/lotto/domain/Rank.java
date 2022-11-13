package lotto.domain;

import java.text.NumberFormat;

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

    public boolean isMatchMatchingNumber(int matchingNumber) {
        if (matchingNumber == match) return true;
        return false;
    }

    public void addCount() {
        count++;
    }

    public boolean containBonus() {
        if (bonus) return true;
        return false;
    }

    public long getTotalReward() {
        return (reward * count);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(match).append("개 일치");
        if (bonus) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append(" (").append(NumberFormat.getInstance().format(reward))
                .append("원) - ").append(count).append("개");
        return sb.toString();
    }

    public int getRanking() {
        return ranking;
    }
}
