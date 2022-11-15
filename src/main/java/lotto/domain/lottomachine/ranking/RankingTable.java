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
    private final static int THIRD_DECIMAL_PLACE = 3;
    private final static String RATE_OF_RETURN_FORMAT = "###,###.0%";
    private final Map<Ranking, Frequency> frequenciesByRank;

    public RankingTable(Map<Ranking, Frequency> frequenciesByRank) {
        this.frequenciesByRank = frequenciesByRank;
    }

    public String calculateRateOfReturn(Payment money) {
        BigDecimal currentValue = calculateCurrentValue();
        BigDecimal originalValue = money.createBigDecimal();
        return changeFormat(currentValue.divide(originalValue, THIRD_DECIMAL_PLACE, RoundingMode.HALF_UP));
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

    private String changeFormat(BigDecimal rateOfReturn) {
        DecimalFormat formatter = new DecimalFormat(RATE_OF_RETURN_FORMAT);
        return formatter.format(rateOfReturn);
    }

    public List<Map.Entry<Ranking, Frequency>> getEntryByAscendingRanking() {
        return frequenciesByRank.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> getCashOfRanking(entry.getKey())))
                .collect(Collectors.toList());
    }
}
