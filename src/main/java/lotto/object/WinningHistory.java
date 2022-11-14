package lotto.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningHistory {
    private Map<Integer, WinningAmount> history;

    public WinningHistory() {
        this.history = Arrays
                .stream(WinningResult.values())
                .collect(Collectors
                        .toMap(WinningResult::getMatchNumber, WinningAmount::new));
    }

    @Override
    public String toString() {
        List<WinningAmount> amounts = new ArrayList<>(history.values());
        amounts.sort(new WinningAmountComparator());

        StringBuilder sb = new StringBuilder();
        amounts.stream().forEach(amount -> {
            sb.append(amount);
            sb.append("\n");
        });

        return sb.toString();
    }

    private class WinningAmountComparator implements Comparator<WinningAmount> {
        @Override
        public int compare(WinningAmount amount1, WinningAmount amount2) {
            if (amount1.getResultPrize() > amount2.getResultPrize()) {
                return -1;
            }
            if (amount1.getResultPrize() < amount2.getResultPrize()) {
                return 1;
            }
            return 0;
        }
    }
}
