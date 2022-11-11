package lotto.view;

import lotto.type.PlaceType;

import java.util.Map;
import java.util.Set;

public class LottoStatisticView extends View {
    private final Map<PlaceType, Integer> winStatistics;
    private final int numberOfPurchases;

    public LottoStatisticView(Map<PlaceType, Integer> winStatistics, int numberOfPurchases) {
        this.winStatistics = winStatistics;
        this.numberOfPurchases = numberOfPurchases;
    }

    @Override
    public void show() {
        printLine("당첨 통계");
        printLine("---");

        Set<PlaceType> winStatisticKeys = this.winStatistics.keySet();
        long rewardMoney = winStatisticKeys
                .stream()
                .mapToInt(placeType -> placeType.getReward() * this.winStatistics.get(placeType))
                .sum();

        for (PlaceType placeType: winStatisticKeys) {
            printLine(String.format("%s - %d개", placeType.toString(), this.winStatistics.get(placeType)));
        }

        printLine(String.format("총 수익률은 %f%%입니다.", this.calculateRevenue(rewardMoney)));
    }

    private float calculateRevenue(long rewardMoney) {
        return (rewardMoney / (this.numberOfPurchases * 1000F)) * 100;
    }
}
