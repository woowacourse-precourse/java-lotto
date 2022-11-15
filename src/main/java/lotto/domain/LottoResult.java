package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final Long ZERO = 0L;
    private static final double DEFAULT_RATIO = 100.0;

    private final EnumMap<LottoPrize, Long> result = new EnumMap<>(LottoPrize.class);

    public LottoResult(Map<LottoPrize, Long> result) {
        this.result.putAll(result);
    }

    public double calculateProfitRatio() {
        return calculateTotalPrize().divide(calculatePayAmount()) * DEFAULT_RATIO;
    }

    private Money calculateTotalPrize() {
        return Arrays.stream(LottoPrize.values())
                .map(prize -> prize.calculatePrize(this.getCount(prize)))
                .reduce(Money.ZERO, Money::plus);
    }

    private Money calculatePayAmount() {
        return LottoSeller.LOTTO_PRICE.times(Arrays.stream(LottoPrize.values())
                .map(this::getCount)
                .reduce(ZERO, Long::sum));
    }

    public Long getCount(LottoPrize lottoPrize) {
        return result.getOrDefault(lottoPrize, ZERO);
    }

    public EnumMap<LottoPrize, Long> value() {
        return new EnumMap<>(result);
    }
}
