package lotto.domain;

public interface MoneyProcessor {

    String calculateMargin(double beforeMoney, double afterMoney);

    Integer calculateLottoCount(Integer money);
}
