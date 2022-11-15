package view;

import lotto.Lotto;
import lotto.LottoTickets;
import lotto.Ranking;
import lotto.WinningResult;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {
    private static final String OUTPUT_TICKET_COUNT = "개를 구매했습니다.";
    private static final String OUTPUT_PROFIT = "총 수익률은 %.2f입니다.";
    private static final String SAME_BALL_COUNT = "%d개 일치";
    private static final String SAME_BONUS_BALL = ",보너스 볼 일치";
    private static final String OUTPUT_MONEY_NUM = "(%d원) - %d개%s";


    public static void outputTicketCount(int count) {
        System.out.println(count + OUTPUT_TICKET_COUNT);
    }

    public static void outputTicket(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets.getLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void outputWinningResult(WinningResult winningResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Ranking, Integer> result : getResultEntry(winningResult)) {
            Ranking ranking = result.getKey();
            int count = result.getValue();
            printResult(ranking, count, stringBuilder);
        }
    }
    public static void outputException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printProfit(double profit) {
        String sentence = String.format(OUTPUT_PROFIT, profit);
        System.out.println(sentence);
    }
    private static List<Map.Entry<Ranking, Integer>> getResultEntry(WinningResult winningResult) {
        return winningResult.getWinningResult().entrySet()
                .stream()
                .filter(entry -> entry.getKey() != Ranking.FAILED)
                .sorted(Comparator.comparingInt(a -> a.getKey().getPrize()))
                .collect(Collectors.toList());
    }

    private static void printResult(Ranking ranking, int count, StringBuilder stringBuilder) {
        String sentence = String.format(SAME_BALL_COUNT, ranking.getCount());
        stringBuilder.append(sentence);
        if (ranking.isBonus()) {
            stringBuilder.append(SAME_BONUS_BALL);
        }
        String result = String.format(OUTPUT_MONEY_NUM, ranking.getPrize(), count, System.lineSeparator());
        stringBuilder.append(result);
    }

}
