package lotto;

public enum LotteryWin {
    FIRST_GRADE("2,000,000,000"),
    SECOND_GRADE("30,000,000"),
    THIRD_GRADE("1,500,000"),
    FOURTH_GRADE("50,000"),
    FIFTH_GRADE("5,000");

    private String lotteryWinMoney;

    private LotteryWin(String lotteryWinMoney) {
        this.lotteryWinMoney = lotteryWinMoney;
    }
    public String getLotteryWinMoney() {
        return lotteryWinMoney;
    }
}
