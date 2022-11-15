package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class CompareEachLotto {
    public static final int THREE_NUMBERS = 3;
    public static final int FOUR_NUMBERS = 4;
    public static final int FIVE_NUMBERS = 5;
    public static final double SIX_NUMBERS = 6;
    public static final int ADD_COUNT = 1;
    public static final int INITIAL_VALUE = 0;
    public static final String BEFORE_PRINT_WINNING_HISTORY = "당첨 통계";
    public static final String DIVIDING_LINE = "---";

    private static final Map<Rank, Integer> winningCountMapByRank = new EnumMap<>(Rank.class);
    private static int sumWinningMoney = 0;
    private static int lottoCount = 0;

    private CompareEachLotto() {

    }

    public static void mapInit() {
        for (Rank rank : Rank.values()) {
            winningCountMapByRank.put(rank, INITIAL_VALUE);
        }
    }

    public static void compare(Lotto lotto, WinningNumbers winningNumbers) {
        lottoCount += ADD_COUNT;
        int matchingCount = lotto.countMatchingNumbers(winningNumbers.getSixNumbers());
        if (matchingCount == FIVE_NUMBERS && lotto.contains(winningNumbers.getBonusNumber())) {
            winningCountMapByRank.put(Rank.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHING,
                    winningCountMapByRank.get(Rank.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHING)
                            + ADD_COUNT);
            sumWinningMoney += Rank.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHING.getWinningMoney();
        }
        if (matchingCount == SIX_NUMBERS) {
            winningCountMapByRank.put(Rank.SIX_NUMBERS_MATCHING,
                    winningCountMapByRank.get(Rank.SIX_NUMBERS_MATCHING)
                            + ADD_COUNT);
            sumWinningMoney += Rank.SIX_NUMBERS_MATCHING.getWinningMoney();
        }
        if (matchingCount == FIVE_NUMBERS) {
            winningCountMapByRank.put(Rank.ONLY_FIVE_NUMBERS_MATCHING,
                    winningCountMapByRank.get(Rank.ONLY_FIVE_NUMBERS_MATCHING)
                            + ADD_COUNT);
            sumWinningMoney += Rank.ONLY_FIVE_NUMBERS_MATCHING.getWinningMoney();
        }
        if (matchingCount == FOUR_NUMBERS) {
            winningCountMapByRank.put(Rank.FOUR_NUMBERS_MATCHING,
                    winningCountMapByRank.get(Rank.FOUR_NUMBERS_MATCHING)
                            + ADD_COUNT);
            sumWinningMoney += Rank.FOUR_NUMBERS_MATCHING.getWinningMoney();
        }
        if (matchingCount == THREE_NUMBERS) {
            winningCountMapByRank.put(Rank.THREE_NUMBERS_MATCHING,
                    winningCountMapByRank.get(Rank.THREE_NUMBERS_MATCHING)
                            + ADD_COUNT);
            sumWinningMoney += Rank.THREE_NUMBERS_MATCHING.getWinningMoney();
        }
    }

    public static void printWinningHistory() {
        System.out.println(BEFORE_PRINT_WINNING_HISTORY);
        System.out.println(DIVIDING_LINE);

        Rank.THREE_NUMBERS_MATCHING.printRank();
        System.out.println(winningCountMapByRank.get(Rank.THREE_NUMBERS_MATCHING) + Lotto.LOTTO_UNIT);

        Rank.FOUR_NUMBERS_MATCHING.printRank();
        System.out.println(winningCountMapByRank.get(Rank.FOUR_NUMBERS_MATCHING) + Lotto.LOTTO_UNIT);

        Rank.ONLY_FIVE_NUMBERS_MATCHING.printRank();
        System.out.println(winningCountMapByRank.get(Rank.ONLY_FIVE_NUMBERS_MATCHING) + Lotto.LOTTO_UNIT);

        Rank.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHING.printRank();
        System.out.println(winningCountMapByRank.get(Rank.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHING) + Lotto.LOTTO_UNIT);

        Rank.SIX_NUMBERS_MATCHING.printRank();
        System.out.println(winningCountMapByRank.get(Rank.SIX_NUMBERS_MATCHING) + Lotto.LOTTO_UNIT);

        System.out.println("총 수익률은 " +
                String.format("%.1f", (sumWinningMoney / ((double) lottoCount * 1000)) * 100) + "%입니다.");
    }

}
