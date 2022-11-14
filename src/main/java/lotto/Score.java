package lotto;

public enum Score {
    zero(0, 0), six(6, 2_000_000_000), fifth(5, 1_500_000), fifthBonus(55, 30_000_000), fourth(4, 50_000), third(3, 5_000);

    final int value;
    final int money;

    Score(int value, int money) {
        this.value = value;
        this.money = money;
    }

    public static Score getWinValue(int num) {
        for (Score winValue : Score.values()) {
            if (winValue.value == num) {
                return winValue;
            }
        }
        return null;
    }

    public int getMoney() {
        return money;
    }
}