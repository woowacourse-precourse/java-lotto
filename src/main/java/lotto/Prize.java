package lotto;

public enum Prize {
    NOTHING(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    JACKPOT(6, false, 2_000_000_000);

    private final int numsOfMatchedNumber;
    private final boolean containBonus;
    private final int prize;
    private int numsOfWinner;

    Prize(int numsOfMatchedNumber, boolean containBonus, int prize) {
        this.numsOfMatchedNumber = numsOfMatchedNumber;
        this.containBonus = containBonus;
        this.prize = prize;
        this.numsOfWinner = 0;
    }

    private void plusNumsOfWinner() {
        this.numsOfWinner++;
    }

    public static void checkRanking(int numsOfMatchedNumber, boolean containBonus, int prize) {
        if (numsOfMatchedNumber == 6) {
            Prize.JACKPOT.plusNumsOfWinner();
        }
        if (numsOfMatchedNumber == 5 && containBonus) {
            Prize.SECOND.plusNumsOfWinner();
        }
        if (numsOfMatchedNumber == 5) {
            Prize.THIRD.plusNumsOfWinner();
        }
        if (numsOfMatchedNumber == 4) {
            Prize.FOURTH.plusNumsOfWinner();
        }
        if (numsOfMatchedNumber == 3) {
            Prize.FIFTH.plusNumsOfWinner();
        }
    }
}
