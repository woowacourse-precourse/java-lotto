package lotto;

public enum WinningNumberAndEarningPair {
    CORRECT_3_UNDER(0),
    CORRECT_3(5000),
    CORRECT_4(50000),
    CORRECT_5(1500000),
    CORRECT_5_BONUS(30000000),
    CORRECT_6(2000000000);

    private final int earning;

    WinningNumberAndEarningPair(int earning) {
        this.earning = earning;
    }

    public int getEarning() {
        return earning;
    }
}
