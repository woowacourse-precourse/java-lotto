package lotto;

public class Prize {
    private final int money;

    Prize(int winningNumberCount, int bonusNumberCount) {
        money = Ranks.getPrizeMoneyBy(winningNumberCount, bonusNumberCount);
    }

    public int getMoney() {
        return money;
    }
}
