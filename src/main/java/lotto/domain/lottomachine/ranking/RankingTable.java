package lotto.domain.lottomachine.ranking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankingTable {
    private final Map<Ranking, Integer> frequenciesByRank;

    public RankingTable(Map<Ranking, Integer> frequenciesByRank) {
        this.frequenciesByRank = frequenciesByRank;
    }

    public String calculateRateOfReturn(int money) {
        BigDecimal currentValue = calculateCurrentValue();
        BigDecimal originalValue = BigDecimal.valueOf(money);
        return changeToRateOfReturnFormat(currentValue.divide(originalValue, 3, RoundingMode.HALF_UP));
    }

    private BigDecimal calculateCurrentValue() {
        return frequenciesByRank.entrySet()
                .stream()
                .map(entry -> BigDecimal.valueOf(entry.getKey().getCash()).multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private String changeToRateOfReturnFormat(BigDecimal rateOfReturn) {
        DecimalFormat formatter = new DecimalFormat("###,###.0%");
        return formatter.format(rateOfReturn);
    }

    public List<List<String>> getAllByAscendingRanking() {
        return frequenciesByRank.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getCash()))
                .map(entry ->List.of(entry.getKey().getNumberOfMatching(), entry.getKey().getCashInDecimalFormat(), String.valueOf(entry.getValue())))
                .collect(Collectors.toList());
    }
}
