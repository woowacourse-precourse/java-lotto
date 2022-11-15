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

    public static final int FIFTH_PRIZE_CRITERION_FOR_WINNING_MATCH = 3;
    public static final int FOURTH_PRIZE_CRITERION_FOR_WINNING_MATCH = 4;
    public static final int THIRD_PRIZE_CRITERION_FOR_WINNING_MATCH = 5;
    public static final int THIRD_PRIZE_CRITERION_FOR_BONUS_MATCH = 0;
    public static final int SECOND_PRIZE_CRITERION_FOR_WINNING_MATCH = 5;
    public static final int SECOND_PRIZE_CRITERION_FOR_BONUS_MATCH = 1;
    public static final int FIRST_PRIZE_CRITERION_FOR_WINNING_MATCH = 6;
    public static final String UNIT = "개";

    private final int money;
    private final BiPredicate<Integer, Integer> judge;
    private final String message;

    Prize(int money, BiPredicate<Integer, Integer> judge, String message) {
        this.money = money;
        this.judge = judge;
        this.message = message;
    }

    private static BiPredicate<Integer, Integer> judgeNone() {
        return (winningMatches, bonusMatches) -> isNone(winningMatches);
    }

    private static boolean isNone(Integer winningMatches) {
        return winningMatches < FIFTH_PRIZE_CRITERION_FOR_WINNING_MATCH;
    }

    private static BiPredicate<Integer, Integer> judgeFifth() {
        return (winningMatches, bonusMatches) -> isFifth(winningMatches);
    }

    private static boolean isFifth(Integer winningMatches) {
        return winningMatches == FIFTH_PRIZE_CRITERION_FOR_WINNING_MATCH;
    }

    private static BiPredicate<Integer, Integer> judgeFourth() {
        return (winningMatches, bonusMatches) -> isFourth(winningMatches);
    }

    private static boolean isFourth(Integer winningMatches) {
        return winningMatches == FOURTH_PRIZE_CRITERION_FOR_WINNING_MATCH;
    }

    private static BiPredicate<Integer, Integer> judgeThird() {
        return Prize::isThird;
    }

    private static boolean isThird(Integer winningMatches, Integer bonusMatches) {
        return winningMatches == THIRD_PRIZE_CRITERION_FOR_WINNING_MATCH
                && bonusMatches == THIRD_PRIZE_CRITERION_FOR_BONUS_MATCH;
    }

    private static BiPredicate<Integer, Integer> judgeSecond() {
        return Prize::isSecond;
    }

    private static boolean isSecond(Integer winningMatches, Integer bonusMatches) {
        return winningMatches == SECOND_PRIZE_CRITERION_FOR_WINNING_MATCH
                && bonusMatches == SECOND_PRIZE_CRITERION_FOR_BONUS_MATCH;
    }

    private static BiPredicate<Integer, Integer> judgeFirst() {
        return (winningMatches, bonusMatches) -> isFirst(winningMatches);
    }

    private static boolean isFirst(Integer winningMatches) {
        return winningMatches == FIRST_PRIZE_CRITERION_FOR_WINNING_MATCH;
    }

    public static Prize judge(int winningMatches, int bonusMatches) {
        return Arrays.stream(Prize.values())
                .filter(it -> it.find(winningMatches, bonusMatches))
                .findFirst()
                .orElse(Prize.NONE);
    }

    private boolean find(int winningMatches, int bonusMatches) {
        return judge.test(winningMatches, bonusMatches);
    }

    public int getMoney() {
        return money;
    }

    public void printMessageWithCount(Long count) {
        String countMessage = this.message + count + UNIT;
        System.out.println(countMessage);
    }
}
