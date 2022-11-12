package lotto.domain;

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
        if(matchingNumber == match) return true;
        return false;
    }

    public void addCount() {
        count++;
    }

    public boolean containBonus() {
        if(bonus) return true;
        return false;
    }

    public long getTotalReward() {
        return (reward * count);
    }
}
