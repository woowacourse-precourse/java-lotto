package lotto;

import java.util.Map;

public class Calculate {
    
    public static String getProfitRate(long purchaseAmount, Map<LottoMatch, Long> winningDetails) {
        long winningAmount = 0L;
        for (Map.Entry<LottoMatch, Long> entry : winningDetails.entrySet()) {
            winningAmount += entry.getKey().getValue() * entry.getValue();
        }
        return String.format("%.1f", (double) winningAmount / purchaseAmount * 100);
    }
}
