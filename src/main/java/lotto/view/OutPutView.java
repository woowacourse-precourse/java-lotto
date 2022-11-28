package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.ResponseRankAggregationDto;
import lotto.service.YieldService;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutPutView {

    private static DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private static YieldService yieldService = new YieldService();

    public static void showCustomerLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void showRankAggregation(ResponseRankAggregationDto responseRankAggregationDto, int payment) {
        showAggregationForm();
        showRankAggregationCount(responseRankAggregationDto);
        showYield(responseRankAggregationDto, payment);
    }

    private static void showAggregationForm() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private static void showRankAggregationCount(ResponseRankAggregationDto rankAggregationDto) {
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

    private static void showYield(ResponseRankAggregationDto rankAggregationDto, int payment) {
        String calculate = yieldService.calculate(rankAggregationDto, payment);
        System.out.println("총 수익률은 " + calculate + "%입니다.");
    }
}
