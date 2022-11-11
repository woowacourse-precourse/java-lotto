package lotto;

public class Prize {
    private Ranks rank;
    private final int money;

    Prize(int winningNumberCount, int bonusNumberCount) {
        rank = Ranks.getRankBy(winningNumberCount, bonusNumberCount);
        money = rank.getPrizeMoney();
    }

    public int getMoney() {
        return money;
    }
}
