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
    private final Map<Ranking, Frequency> frequenciesByRank;

    public RankingTable(Map<Ranking, Frequency> frequenciesByRank) {
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

    private BigDecimal multiplyCashAndFrequency(Map.Entry<Ranking, Frequency> entry) {
        BigDecimal cash = getCashOfRanking(entry.getKey());
        BigDecimal frequency = getFrequency(entry.getValue());
        return cash.multiply(frequency);
    }

    private BigDecimal getCashOfRanking(Ranking value) {
        return value.getCashToBigDecimal();
    }

    private BigDecimal getFrequency(Frequency frequency) {
        return frequency.toBigDecimal();
    }

    private String changeToRateOfReturnFormat(BigDecimal rateOfReturn) {
        DecimalFormat formatter = new DecimalFormat("###,###.0%");
        return formatter.format(rateOfReturn);
    }

    public List<List<String>> getAllByAscendingRanking() {
        return frequenciesByRank.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getCash()))
                .map(entry -> List.of(entry.getKey().getNumberOfMatching(), entry.getKey().getCashInDecimalFormat(), entry.getValue().toString()))
                .collect(Collectors.toList());
    }
}
