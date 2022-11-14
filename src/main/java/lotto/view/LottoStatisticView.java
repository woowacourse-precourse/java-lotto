package lotto.view;

import lotto.Env;
import lotto.type.PrizeType;
import lotto.util.Lang;
import java.util.Map;

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
                .stream()
                .sorted()
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

    private double calculateRevenue() {
        return (double) (this.profit * 100) / (this.countTicket() * Env.LOTTO_PRICE);
    }

    private int countTicket() {
        return this.status
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
