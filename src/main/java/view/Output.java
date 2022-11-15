package view;

import lotto.Lotto;

public class Output {
    private static final String BUY_MESSAGE = "%d개를 구매했습니다.";
    private static final String RESULT_START_MESSAGE = "당첨 통계\n---";
    private static final String RESULT_RANK_MESSAGE = "%d개 일치 (%s원)- %d개";
    private static final String RESULT_BOUNS_RANK_MESSAGE = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.2f%입니다.";

    public static void printBoughtLotteryNumber(int count) {
        System.out.printf(BUY_MESSAGE, count);
    }

    public static void printRandomLotteryNumber(Lotto lotto) {

    }
}
