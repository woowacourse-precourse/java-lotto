package lotto.view;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String TICKET_NUMBER_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_TITLE_MESSAGE = "당첨 통계\n---";
    private static final String RESULT_WINNING_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String RESULT_SECOND_WINNING_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String RESULT_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printTicketNumber(int number) {
        System.out.println(number + TICKET_NUMBER_MESSAGE);
    }

    public static void printTickets(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningHistory(Map<Rank, Integer> winningHistory) {
        System.out.println(RESULT_TITLE_MESSAGE);
        for (Rank rank : winningHistory.keySet()) {
            if (rank == Rank.NONE) {
                continue;
            }
            System.out.printf(isSecondMessage(rank), rank.getCorrectCount(), rank.getPrizeWithComna(), winningHistory.get(rank));
        }
    }

    public static void printProfit(double profit) {
        System.out.printf(RESULT_PROFIT_MESSAGE, profit);
    }

    private static String isSecondMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return RESULT_SECOND_WINNING_MESSAGE;
        }
        return RESULT_WINNING_MESSAGE;
    }
}
