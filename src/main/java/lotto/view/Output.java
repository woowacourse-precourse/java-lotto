package lotto.view;

import lotto.domain.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {

    static final String OUTPUT_RESULT_TITLE = "당첨 통계";
    static final String OUTPUT_RESULT_LINE = "---";
    static final String OUTPUT_OPEN_PARENTHESIS = "[";
    static final String OUTPUT_CLOSE_PARENTHESIS = "]";

    public Output() {
    }

    public static void printTitle() {
        System.out.println(OUTPUT_RESULT_TITLE);
        System.out.println(OUTPUT_RESULT_LINE);
    }

    public static void printWinningStatistic(Result result) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Ranking, Integer> entry : getResultEntryList(result)) {
            Ranking ranking = entry.getKey();
            int count = entry.getValue();
            makeWinningResult(ranking, count, stringBuilder);
        }

        System.out.print(stringBuilder);
    }

    private static List<Map.Entry<Ranking, Integer>> getResultEntryList(Result result) {
        return result.getResult().entrySet().stream()
                .filter(set -> set.getKey() != Ranking.NOTHING)
                .sorted(Comparator.comparingInt(i -> i.getKey().getMoney()))
                .collect(Collectors.toList());
    }

    private static void makeWinningResult(Ranking ranking, int count, StringBuilder stringBuilder) {
        String winningTitle = String.format("%d개 일치", ranking.getCount());
        stringBuilder.append(winningTitle);

        if (ranking.isHasBonusNumber()) {
            String hasBonus = ", 보너스 볼 일치";
            stringBuilder.append(hasBonus);
        }

        String winningMoney = String.format(" (%s원) - %d개", ranking.getOutputMoney(), count);
        stringBuilder.append(winningMoney).append("\n");
    }

    public static void printTicketsList(PurchaseAmount purchaseAmount, LottoTicket lottoTicket) {
        StringBuilder stringBuilder = new StringBuilder();

        int ticketCount = purchaseAmount.getPurchaseAmount();
        String ticketCountSentence = String.format("%d개를 구매했습니다.", ticketCount / 1000);
        stringBuilder.append(ticketCountSentence).append("\n");

        List<Lotto> tickets = lottoTicket.getLottoTickets();
        for (Lotto lotto : tickets) {
            makeTicketResult(lotto, stringBuilder);
        }
        System.out.println(stringBuilder);
    }

    private static void makeTicketResult(Lotto lotto, StringBuilder stringBuilder) {
        List<Integer> numbers = lotto.getNumbers();
        stringBuilder.append(OUTPUT_OPEN_PARENTHESIS);
        stringBuilder.append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            String number = String.format(", %d", numbers.get(i));
            stringBuilder.append(number);
        }
        stringBuilder.append(OUTPUT_CLOSE_PARENTHESIS).append("\n");
    }

    public static void printYield(double yield) {
        String yieldSentence = String.format("총 수익률은 %.1f%%입니다.", yield * 100);
        System.out.println(yieldSentence);
    }

}
