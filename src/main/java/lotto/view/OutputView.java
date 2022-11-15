package lotto.view;

import static lotto.util.ErrorMessage.ERROR_MESSAGE;
import static lotto.util.Formatter.formatCashPrize;

import java.util.List;
import lotto.model.Rank;

public class OutputView {
    public static final String REQUEST_CASH = "구입금액을 입력해 주세요.";
    public static final String RESPOND_TICKET_NUMBER = "%d개를 구매했습니다.";
    public static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String RESPOND_STATISTICS = "당첨 통계";
    public static final String DIVIDER = "---";
    public static final String RESPOND_YIELD = "총 수익률은 %s%%입니다.\n";

    public static void printErrorMessage(Exception error) {
        System.out.printf(ERROR_MESSAGE, error.getMessage());
    }

    public static void printCashInput() {
        System.out.println(REQUEST_CASH);
    }

    public static void printTicketNumber(int ticketNumber) {
        System.out.printf(RESPOND_TICKET_NUMBER, ticketNumber);
    }

    public static void printWinningNumberInput() {
        System.out.println(REQUEST_WINNING_NUMBER);
    }

    public static void printBonusNumberInput() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }

    public static void printAllPlayerNumbers(List<List<Integer>> allPlayerNumbers) {
        for (List<Integer> playerNumbers : allPlayerNumbers) {
            System.out.println(playerNumbers);
        }
    }

    public static void printStatistics(List<Rank> ranks) {
        System.out.println(RESPOND_STATISTICS);
        System.out.println(DIVIDER);

        for (Rank rank : ranks) {
            if (rank == Rank.NONE) {
                continue;
            }
            System.out.printf(rank.getPrintMessage(), formatCashPrize(rank.getCashPrize()), rank.getCount());
        }
    }

    public static void printYield(String yield) {
        System.out.printf(RESPOND_YIELD, yield);
    }
}
