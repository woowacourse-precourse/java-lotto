package lotto.domain.util;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Winning {
    NOTHING("", x -> x < 3, 0, 0),
    THREE("3개 일치 (5,000원) - ", x -> x == 3, 0, 5_000),
    FOUR("4개 일치 (50,000원) - ", x -> x == 4, 0, 50_000),
    FIVE("5개 일치 (1,500,000원) - ", x -> x == 5, 0, 1_500_000),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            x -> false, 0, 300_00_000),
    SIX("6개 일치 (2,000,000,000원) - ", x -> x == 6, 0, 2_000_000_000);

    private final String winningMessage;
    private final Predicate<Integer> predicate;
    private final int value;
    private int count;

    Winning(String winningMessage, Predicate<Integer> predicate, int count, int value) {
        this.winningMessage = winningMessage;
        this.predicate = predicate;
        this.count = count;
        this.value = value;
    }

    private boolean test(int count) {
        return predicate.test(count);
    }

    private static void initCount(){
        for (Winning winning : Winning.values()) {
            winning.count = 0;
        }
    }

    public static void findWinningValue(int count, Lotto winningNumbers, int bonus) {
        initCount();

        Winning win = Arrays.stream(Winning.values())
                .filter(winning -> winning.test(count))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

        win = isContainBonusNumber(win, winningNumbers, bonus);
        win.count += 1;
    }

    private static Winning isContainBonusNumber(Winning win, Lotto winningNumbers, int bonus) {
        if (win == FIVE && winningNumbers.getNumbers().contains(bonus)) {
            return FIVE_AND_BONUS;
        }
        return win;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public Predicate<Integer> getPredicate() {
        return predicate;
    }

    public int getCount() {
        return count;
    }

    public int getValue() {
        return value;
    }
}
