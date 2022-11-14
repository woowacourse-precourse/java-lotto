package lotto.view;


import lotto.type.PrizeType;
import lotto.util.Lang;

import java.util.Map;
import java.util.Set;

public class LottoStatisticView extends View {
    private final Map<PrizeType, Integer> status;
    private final long profit;

    public LottoStatisticView(Map<PrizeType, Integer> status, long profit) {
        this.status = status;
        this.profit = profit;
    }

    @Override
    public void show() {
        printLine(Lang.VIEW_WINNING_STATS);
        printLine("---");

        this.status
                .keySet()
                .forEach(this::showStatus);

        printLine(Lang.format(Lang.VIEW_TOTAL_RETURNS, this.calculateRevenue()));
    }

    private void showStatus(PrizeType prizeType) {
        if (prizeType != PrizeType.NOTHING) {
            printLine(Lang.format(
                    Lang.VIEW_STATS_UNIT,
                    prizeType.toString(),
                    this.status.get(prizeType)
            ));
        }
    }

    private float calculateRevenue() {
        return (this.profit / (this.status.size() * 1000F)) * 100;
    }
}
