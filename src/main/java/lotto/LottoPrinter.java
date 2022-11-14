package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoPrinter {
    public static void printLotto(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(lotto -> {
            System.out.print("[");
            System.out.print(lotto.getNumbers().stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println("]");
        });
    }

    public static void printStatistics(Map<LottoPrize, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LottoPrize> prizes = List.of(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD, LottoPrize.SECOND,
                LottoPrize.FIRST);
        prizes.forEach(prize -> printPrizeStatistic(prize, statistics));
    }

    private static void printPrizeStatistic(LottoPrize prize, Map<LottoPrize, Integer> statistics) {
        int count = statistics.get(prize);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formattedReward = decimalFormat.format(prize.reward);
        System.out.printf("%s (%s원) - %d개\n", prize.matchCount, formattedReward, count);
    }

    public static void printRateOfReturn(Double rateOfReturn) {
        System.out.println("총 수익률은 "+ rateOfReturn + "%입니다.");
    }
}
