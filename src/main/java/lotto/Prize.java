package lotto;

public enum Prize {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    JACKPOT(6, false, 2_000_000_000);

    private final int matchedNumbers;
    private final boolean containBonus;
    private final int prize;
    private int numsOfWinner;

    Prize(int matchedNumbers, boolean containBonus, int prize) {
        this.matchedNumbers = matchedNumbers;
        this.containBonus = containBonus;
        this.prize = prize;
        this.numsOfWinner = 0;
    }
    public int getPrize(){
        return this.prize;
    }
    public int getMatchedNumbers() {
        return this.matchedNumbers;
    }

    public boolean getContainBonus() {
        return this.containBonus;
    }

    public int getNumsOfWinner() {
        return this.numsOfWinner;
    }

    private void plusNumsOfWinner() {
        this.numsOfWinner++;
    }

    public static void checkRanking(int numsOfMatchedNumber, boolean containBonus) {
        if (numsOfMatchedNumber == 6) {
            Prize.JACKPOT.plusNumsOfWinner();
        }
        if (numsOfMatchedNumber == 5 && containBonus) {
            Prize.SECOND.plusNumsOfWinner();
        }
        if (numsOfMatchedNumber == 5 && !containBonus) {
            Prize.THIRD.plusNumsOfWinner();
        }
        if (numsOfMatchedNumber == 4) {
            Prize.FOURTH.plusNumsOfWinner();
        }
        if (numsOfMatchedNumber == 3) {
            Prize.FIFTH.plusNumsOfWinner();
        }
    }

    public static int getComputedIncome() {
        int totalIncome = 0;
        for (Prize rank : Prize.values()) {
            totalIncome += rank.numsOfWinner * rank.prize;
        }
        return totalIncome;
    }

    public static float getComputeIncomeRate(int seedMoney) {
        int totalIncome = getComputedIncome();
        return (totalIncome / (float) seedMoney) * 100f;
    }
}
