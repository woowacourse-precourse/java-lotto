package lotto.view;

import java.util.List;

public class GameOutput {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.\n";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.\n";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---\n";
    private static final String THREE_MATCHES = "3개 일치 (%s원) - %d개\n";
    private static final String FOUR_MATCHES = "4개 일치 (%s원) - %d개\n";
    private static final String FIVE_MATCHES = "5개 일치 (%s원) - %d개\n";
    private static final String FIVE_PLUS_BONUS_MATCHES = "5개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String SIX_MATCHES = "6개 일치 (%s원) - %d개\n";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.\n";

    public static void printMoneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public static void printBuyMessage(int lottoAmount) {
        System.out.printf(BUY_MESSAGE, lottoAmount);
    }

    public static void printNumberInput() {
        System.out.printf(NUMBER_INPUT_MESSAGE);
    }

    public static void printBonusNumberInput() {
        System.out.printf(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printWinningStatistics() {
        System.out.printf(WINNING_STATISTICS);
    }

    public static void printThreeMatches(String money, int matchCount) {
        System.out.printf(THREE_MATCHES, money, matchCount);
    }

    public static void printFourMatches(String money, int matchCount) {
        System.out.printf(FOUR_MATCHES, money, matchCount);
    }

    public static void printFiveMatches(String money, int matchCount) {
        System.out.printf(FIVE_MATCHES, money, matchCount);
    }

    public static void printFivePlusBonusMatches(String money, int matchCount) {
        System.out.printf(FIVE_PLUS_BONUS_MATCHES, money, matchCount);
    }

    public static void printSixMatches(String money, int matchCount) {
        System.out.printf(SIX_MATCHES, money, matchCount);
    }

    public static void printTotalRate(double rate) {
        System.out.printf(TOTAL_RATE_OF_RETURN, rate);
    }

    public static void printLottoNumbers(List<List<Integer>> lotteries) {
        lotteries.stream()
                .forEach(System.out::println);
    }
}
