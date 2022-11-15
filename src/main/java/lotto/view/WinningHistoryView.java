package lotto.view;

import lotto.domain.Rank;
import lotto.dto.RankAggregationDto;
import lotto.service.YieldService;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Map;

public class WinningHistoryView {

    private static DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private static YieldService yieldService = new YieldService();

    public static void showRankAggregation(RankAggregationDto rankAggregationDto, int payment) {
        showAggregationForm();
        showRankAggregationCount(rankAggregationDto);
        showYield(rankAggregationDto, payment);
    }

    private static void showAggregationForm() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private static void showRankAggregationCount(RankAggregationDto rankAggregationDto) {
        rankAggregationDto.getRankAggregationMap()
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getWinningMoney()))
                .forEach(entry -> {
                    if (isRankSecond(entry)) {
                        specialPrint(entry);
                    }

                    if (!isRankSecond(entry)) {
                        defaultPrint(entry);
                    }
                });
    }

    private static boolean isRankSecond(Map.Entry<Rank, Integer> entry) {
        return entry.getKey().equals(Rank.SECOND);
    }

    private static void defaultPrint(Map.Entry<Rank, Integer> entry) {
        System.out.printf("%d개 일치 (%s원) - %d개\n",
                entry.getKey().getMatchCount(),
                decimalFormat.format(entry.getKey().getWinningMoney()),
                entry.getValue());
    }

    private static void specialPrint(Map.Entry<Rank, Integer> entry) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                entry.getKey().getMatchCount(),
                decimalFormat.format(entry.getKey().getWinningMoney()),
                entry.getValue());
    }

    private static void showYield(RankAggregationDto rankAggregationDto, int payment) {
        String calculate = yieldService.calculate(rankAggregationDto, payment);
        System.out.println("총 수익률은 " + calculate + "%입니다.");
    }
}
