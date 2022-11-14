package lotto.view;

import lotto.constant.Rank;

import java.util.List;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_UNIT = "개";
    private static final String SEPARATOR = "---";
    private static final String WINNING_STATS_WORD = "당첨 통계";
    private static final String BEFORE_RATE = "총 수익률은 ";
    private static final String AFTER_RATE = "%입니다.";
    private static final String ERROR = "[ERROR] ";

    // TODO 구매한 로또 번호 출력
    public static void printPurchaseLottoMessage(int count, String message) {
        System.out.println(count + LOTTO_COUNT_MESSAGE);
        System.out.println(message);
    }
    
    // TODO 당첨 통계 출력, 총 수익률 출력
    public static void printWinnings(List<Integer> winningsCount) {
        System.out.println(WINNING_STATS_WORD );
        System.out.println(SEPARATOR);

        int rankIndex = 0;
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getWinningStats() + winningsCount.get(rankIndex++) + LOTTO_UNIT);
        }
    }

    public static void printRateOfReturn(double rate) {
        System.out.println(BEFORE_RATE + rate + AFTER_RATE);
    }

    public static void printExceptionMessage(Exception exception) {
        System.out.println(ERROR + exception.getMessage());
    }
}
