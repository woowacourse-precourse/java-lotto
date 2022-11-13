package lotto.constant;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000, 6, 0),
    SECOND(30000000, 5, 1),
    THIRD(1500000, 5, 0),
    FOURTH( 50000, 4, 0),
    FIFTH( 5000, 3, 0),
    ETC(0, 0, 0);

    private int winnings;
    private int win;
    private int bonus;

    Rank(int winnings, int win, int bonus) {
        this.winnings = winnings;
        this.win = win;
        this.bonus = bonus;
    }

    public int getWin() {
        return win;
    }

    public int getBonus() {
        return bonus;
    }

    // TODO bonus, win 숫자 비교해서 랭킹 반환하는 기능 추가
    public static Rank findByWinAndBonus(int win, int bonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> hasSameWinAndBonus(win, bonus, rank))
                .findAny()
                .orElse(ETC);
    }

    private static boolean hasSameWinAndBonus(int win, int bonus, Rank rank) {
        return rank.getWin() == win && rank.getBonus() == bonus;
    }


    // TODO Rank에 개수 전달해서 내역 문자열 조합해서 반환하는 기능 추가
}
