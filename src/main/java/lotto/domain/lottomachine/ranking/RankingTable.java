package lotto.domain.lottomachine.ranking;

import lotto.domain.lottomachine.payment.Payment;

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

    public String calculateRateOfReturn(Payment money) {
        BigDecimal currentValue = calculateCurrentValue();
        BigDecimal originalValue = money.createBigDecimal();
        return changeToRateOfReturnFormat(currentValue.divide(originalValue, 3, RoundingMode.HALF_UP));
    }

    private BigDecimal calculateCurrentValue() {
        return frequenciesByRank.entrySet()
                .stream()
                .map(this::multiplyCashAndFrequency)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal multiplyCashAndFrequency(Map.Entry<Ranking, Integer> entry) {
        BigDecimal cash = BigDecimal.valueOf(getCashOfRanking(entry));
        BigDecimal frequency = BigDecimal.valueOf(getFrequency(entry));
        return cash.multiply(frequency);
    }

    private int getCashOfRanking(Map.Entry<Ranking, Integer> entry) {
        Ranking value = entry.getKey();
        return value.getCash();
    }

    private int getFrequency(Map.Entry<Ranking, Integer> entry) {
        return entry.getValue();
    }

    private String changeToRateOfReturnFormat(BigDecimal rateOfReturn) {
        DecimalFormat formatter = new DecimalFormat("###,###.0%");
        return formatter.format(rateOfReturn);
    }

    public List<List<String>> getAllByAscendingRanking() {
        return frequenciesByRank.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getCash()))
                .map(entry -> List.of(entry.getKey().getNumberOfMatching(), entry.getKey().getCashInDecimalFormat(), String.valueOf(entry.getValue())))
                .collect(Collectors.toList());
    }
}
