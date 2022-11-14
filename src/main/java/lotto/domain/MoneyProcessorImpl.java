package lotto.domain;

public class MoneyProcessorImpl implements MoneyProcessor {
    @Override
    public String calculateMargin(double beforeMoney, double afterMoney) {
        return String.format("%.1f", afterMoney / beforeMoney * 100);
    }

    @Override
    public Integer calculateLottoCount(Integer money) {
        return money / PriceEnum.LOTTO_PRICE.getValue();
    }
}
