package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final Long ZERO_COUNT = 0L;
    private static final double DEFAULT_RATIO = 100.0;
    private static final double RATIO_OF_ZERO = 0.0;

    private final EnumMap<LottoPrize, Long> result = new EnumMap<>(LottoPrize.class);

    public LottoResult(Map<LottoPrize, Long> result) {
        this.result.putAll(result);
    }

    @Override
    public String toString() {
        return "LottoResult{" + result + '}';
    }

    public double calculateProfitRatio() {
        Money buyAmount = calculatePayAmount();
        if (buyAmount.equals(Money.ZERO)) {
            return RATIO_OF_ZERO;
        }
        return calculateTotalPrize().divide(buyAmount) * DEFAULT_RATIO;
    }

    private Money calculateTotalPrize() {
        return Arrays.stream(LottoPrize.values())
                .map(prize -> prize.calculatePrize(this.getCount(prize)))
                .reduce(Money.ZERO, Money::plus);
    }

    private Money calculatePayAmount() {
        return LottoSeller.LOTTO_PRICE.times(Arrays.stream(LottoPrize.values())
                .map(this::getCount)
                .reduce(ZERO_COUNT, Long::sum));
    }

    public Long getCount(LottoPrize lottoPrize) {
        return result.getOrDefault(lottoPrize, ZERO_COUNT);
    }

    public EnumMap<LottoPrize, Long> value() {
        return new EnumMap<>(result);
    }
}
