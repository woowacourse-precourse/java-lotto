package lotto.domain.processor;

import lotto.domain.enummodel.PriceEnum;
import lotto.domain.enummodel.RankEnum;

import java.util.List;

public class MoneyProcessorImpl implements MoneyProcessor {
    @Override
    public String calculateMargin(double beforeMoney, double afterMoney) {
        return String.format("%.1f", afterMoney / beforeMoney * 100);
    }

    @Override
    public Integer calculateLottoCount(Integer money) {
        return money / PriceEnum.LOTTO_PRICE.getValue();
    }

    @Override
    public Integer calculateWinning(List<Integer> result, RankEnum rankEnum) {
        return Math.toIntExact(result.stream()
                .filter(value -> value == rankEnum.getMatchNumber())
                .count() * rankEnum.getWinnings());
    }
}
