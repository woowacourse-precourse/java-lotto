package lotto.domain;

public class MoneyProcessorImpl implements MoneyProcessor {
    @Override
    public String calculateMargin(double beforeMoney, double afterMoney) {
        return String.format("%.1f", afterMoney/beforeMoney * 100);
    }
}
