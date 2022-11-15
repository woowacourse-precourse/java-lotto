package lotto.domain;

import java.text.NumberFormat;
import java.util.Map;

public class SystemMessage {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String TICKET_PURCHASED_MESSAGE = "개를 구매했습니다.";
    public static final String START_STATISTICS_MESSAGE = "당첨 통계\n---";

    public static void inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public static void printLottoTickets(int numberOfLottoTickets, LottoTickets lottoTickets) {
        System.out.println();
        System.out.println(numberOfLottoTickets + TICKET_PURCHASED_MESSAGE);
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto);
        }
    }

    public static void printWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public static void printBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printResult(Map<Ranking, Integer> result) {
        System.out.println();
        System.out.println(START_STATISTICS_MESSAGE);
        for (Ranking ranking : result.keySet()) {
            if (ranking == Ranking.NOTHING) {
                continue;
            }
            if (ranking == Ranking.SECOND) {
                printSecondPrize(result, ranking);
                continue;
            }
            printCommonResult(result, ranking);
        }
    }

    public static void printProfit(double profit) {
        String formattedProfit = String.format("총 수익률은 %.1f%%입니다.", profit);
        System.out.println(formattedProfit);
    }

    private static String formatting(int number) {
        return NumberFormat.getInstance().format(number);
    }

    private static void printSecondPrize(Map<Ranking, Integer> result, Ranking ranking) {
        System.out.println(
                ranking.getCount() + "개 일치, 보너스 볼 일치 (" +
                        formatting(ranking.getPrize()) + "원) - " +
                        result.get(ranking) + "개");
    }

    private static void printCommonResult(Map<Ranking, Integer> result, Ranking ranking) {
        System.out.println(
                ranking.getCount() + "개 일치 (" +
                        formatting(ranking.getPrize()) + "원) - " +
                        result.get(ranking) + "개"
        );
    }
}
