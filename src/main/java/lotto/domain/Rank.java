package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH( 5000, 3, 0, "3개 일치 (5,000원) - "),
    FOURTH( 50000, 4, 0, "4개 일치 (50,000원) - "),
    THIRD(1500000, 5, 0, "5개 일치 (1,500,000원) - "),
    SECOND(30000000, 5, 1, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000, 6, 0, "6개 일치 (2,000,000,000원) - "),
    ETC(0, 0, 0, "당첨되지 않았습니다.");

    private int winnings;
    private int win;
    private int bonus;
    private String winningStats;

    Rank(int winnings, int win, int bonus, String winningStats) {
        this.winnings = winnings;
        this.win = win;
        this.bonus = bonus;
        this.winningStats = winningStats;
    }

    public boolean isEtc() {
        return this == ETC;
    }

    public int getWinnings() {
        return winnings;
    }

    public int getWin() {
        return win;
    }

    public int getBonus() {
        return bonus;
    }

    public String getWinningStats() {
        return winningStats;
    }

    public static Rank findByWinAndBonus(int win, int bonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> hasSameWinAndBonus(win, bonus, rank))
                .findAny()
                .orElse(ETC);
    }

    private static boolean hasSameWinAndBonus(int win, int bonus, Rank rank) {
        return rank.getWin() == win && rank.getBonus() == bonus;
    }
}
