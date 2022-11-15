package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoPrinter {
    private static final String PURCHASED_ALERT_FORMAT = "%d개를 구매했습니다.\n";
    private static final String STATISTICS_FORMAT = "%s (%s원) - %d개\n";
    private static final String WINNING_STATISTICS_TITLE = "당첨 통계";
    private static final String LINE_SEPARATOR = "---";
    private static final String DECIMAL_PATTERN = "###,###";
    private static final String BRACKET_FORMAT = "[%s]\n";

    public static void printLotto(List<Lotto> lottos) {
        System.out.printf(PURCHASED_ALERT_FORMAT, lottos.size());

        lottos.forEach(lotto -> {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            String lottoNumbersJoinByDelimiter = numbers.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.printf(BRACKET_FORMAT, lottoNumbersJoinByDelimiter);
        });
    }

    public static void printStatistics(Map<LottoPrize, Integer> statistics) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(LINE_SEPARATOR);

        List<LottoPrize> prizesByOrder = List.of(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD,
                LottoPrize.SECOND,
                LottoPrize.FIRST);
        prizesByOrder.forEach(prize -> printPrizeStatistic(prize, statistics));
    }

    private static void printPrizeStatistic(LottoPrize prize, Map<LottoPrize, Integer> statistics) {
        int count = statistics.get(prize);
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);
        String formattedReward = decimalFormat.format(prize.reward);
        System.out.printf(STATISTICS_FORMAT, prize.matchCount, formattedReward, count);
    }

    public static void printRateOfReturn(Double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
