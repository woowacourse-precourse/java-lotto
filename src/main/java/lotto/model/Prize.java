package lotto.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    NONE(0, judgeNone(), "낙첨 입니다."),
    FIFTH(5_000, judgeFifth(), "3개 일치 (5,000원) - "),
    FOURTH(50_000, judgeFourth(), "4개 일치 (50,000원) - "),
    THIRD(1_500_000, judgeThird(), "5개 일치 (1,500,000원) - "),
    SECOND(30_000_000, judgeSecond(), "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2_000_000_000, judgeFirst(), "6개 일치 (2,000,000,000원) - ");

    private final int money;
    private final BiPredicate<Integer, Integer> judge;
    private final String message;

    Prize(int money, BiPredicate<Integer, Integer> judge, String message) {
        this.money = money;
        this.judge = judge;
        this.message = message;
    }

    private static BiPredicate<Integer, Integer> judgeNone() {
        return (winningMatches, bonusMatches) -> winningMatches < 3;
    }

    private static BiPredicate<Integer, Integer> judgeFifth() {
        return (winningMatches, bonusMatches) -> winningMatches == 3;
    }

    private static BiPredicate<Integer, Integer> judgeFourth() {
        return (winningMatches, bonusMatches) -> winningMatches == 4;
    }

    private static BiPredicate<Integer, Integer> judgeThird() {
        return (winningMatches, bonusMatches) -> winningMatches == 5 && bonusMatches == 0;
    }

    private static BiPredicate<Integer, Integer> judgeSecond() {
        return (winningMatches, bonusMatches) -> winningMatches == 5 && bonusMatches == 1;
    }

    private static BiPredicate<Integer, Integer> judgeFirst() {
        return (winningMatches, bonusMatches) -> winningMatches == 6;
    }

    public static Prize judge(int winningMatches, int bonusMatches) {
        return Arrays.stream(Prize.values())
                .filter(it -> it.find(winningMatches, bonusMatches))
                .findFirst().orElseGet(() -> Prize.NONE);
    }

    private boolean find(int winningMatches, int bonusMatches) {
        return judge.test(winningMatches, bonusMatches);
    }
}
