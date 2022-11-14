package lotto.domain;

import java.util.Arrays;

public enum WinningResult {
    // 맞춘 개수와 당첨 금액
    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE(5, 1500000, false),
    BONUS(5, 3000000, true),
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

    // 등수 개수 추가
    private void plusCount() {
        this.count++;
    }

    // 당첨개수와 보너스 여부에 따라 해당 enum 클래스에 count++를 해주기
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
