package lotto.domain;

import java.util.Arrays;

public enum WinningResult {

    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE(5, 1500000, false),
    BONUS(5, 30000000, true),
    SIX(6, 2000000000, false);

    private final int matchingNumbers;
    private final int prize;
    private final boolean bonus;
    private int count;

    WinningResult(int matchingNumbers, int prize, boolean bonus) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.bonus = bonus;
    }

    // 해당 등수 당첨자 추가
    private void plusCount() {
        this.count++;
    }

    // 당첨개수와 보너스 여부 확인 후 당첨자 추가 과정
    public static void plusWinningResult(int numberOfMatch, boolean bonus) {
        if (numberOfMatch == 5) {
            Arrays.stream(values())
                    .filter(statistic -> statistic.matchingNumbers == numberOfMatch)
                    .filter(statistic -> statistic.bonus == bonus)
                    .findFirst()
                    .ifPresent(s -> s.plusCount());
            return;
        }
        Arrays.stream(values())
                .filter(statistic -> statistic.matchingNumbers == numberOfMatch)
                .findFirst()
                .ifPresent(s -> s.plusCount());
    }

    public int getPrize() {
        return this.prize;
    }

    public int getCount() {
        return this.count;
    }
}
