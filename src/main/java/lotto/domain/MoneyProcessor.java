package lotto.domain;

import java.util.List;

public interface MoneyProcessor {

    String calculateMargin(double beforeMoney, double afterMoney);

    Integer calculateLottoCount(Integer money);

    Integer calculateWinning(List<Integer> result, RankEnum rankEnum);
}
