package lotto.view;


import lotto.type.PrizeType;
import lotto.util.Lang;

import java.util.Map;
import java.util.Set;

public class LottoStatisticView extends View {
    private final Map<PrizeType, Integer> winStatistics;
    private final int numberOfPurchases;

    public LottoStatisticView(Map<PrizeType, Integer> winStatistics, int numberOfPurchases) {
        this.winStatistics = winStatistics;
        this.numberOfPurchases = numberOfPurchases;
    }

    @Override
    public void show() {
        printLine(Lang.VIEW_WINNING_STATS);
        printLine("---");

        Set<PrizeType> winStatisticKeys = this.winStatistics.keySet();
        long rewardMoney = winStatisticKeys
                .stream()
                .mapToInt(placeType -> placeType.getReward() * this.winStatistics.get(placeType))
                .sum();

        for (PrizeType placeType: winStatisticKeys) {
            printLine(Lang.format(
                    Lang.VIEW_STATS_UNIT,
                    placeType.toString(),
                    this.winStatistics.get(placeType)
            ));
        }

        printLine(Lang.format(Lang.VIEW_TOTAL_RETURNS, this.calculateRevenue(rewardMoney)));
    }

    private float calculateRevenue(long rewardMoney) {
        return (rewardMoney / (this.numberOfPurchases * 1000F)) * 100;
    }
}
