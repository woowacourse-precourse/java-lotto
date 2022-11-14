package view;

import domain.Ranking;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.Lotto;
import lotto.LottoTickets;

public class OutputView {
    public static final String TICKET_PURCHASED_MESSAGE = "개를 구매했습니다.";
    public static final String START_STATISTICS_MESSAGE = System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---";
    public static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public static void printTicketPurchasedMessage(int count) {
        System.out.println(System.lineSeparator() + count + TICKET_PURCHASED_MESSAGE);
    }

    public static void printGeneratedLottoTickets(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistics(Map<Ranking, Integer> winningStatistics) {
        System.out.println(START_STATISTICS_MESSAGE);
        StringBuilder winningStatisticsMessage = new StringBuilder();
        for (Ranking ranking : winningStatistics.keySet()) {
            generateResultMessage(ranking, winningStatistics, winningStatisticsMessage);
        }
        System.out.print(winningStatisticsMessage);
    }

    private static void generateResultMessage(Ranking ranking, Map<Ranking, Integer> winningStatistics, StringBuilder sb) {
        if (ranking == Ranking.NOTHING) {
            return;
        }
        String countResult = String.format("%d개 일치", ranking.getCount());
        sb.append(countResult);
        if (ranking == Ranking.SECOND) {
            sb.append(", 보너스 볼 일치");
        }
        String prizeResult = String.format(" (%s원) - %d개",
                decimalFormat.format(ranking.getPrize()), winningStatistics.get(ranking)) + System.lineSeparator();
        sb.append(prizeResult);
    }

}
