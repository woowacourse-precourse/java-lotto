package lotto;

public enum LotteryWin {
    FIRST_GRADE(2000000000),
    SECOND_GRADE(30000000),
    THIRD_GRADE(1500000),
    FOURTH_GRADE(50000),
    FIFTH_GRADE(5000),
    NOTHING(0);

    private int lotteryWinMoney;

    private LotteryWin(int lotteryWinMoney) {
        this.lotteryWinMoney = lotteryWinMoney;
    }
    public int getLotteryWinMoney() {
        return lotteryWinMoney;
    }
}
