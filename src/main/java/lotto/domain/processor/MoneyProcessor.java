package lotto.domain.processor;

import lotto.domain.enummodel.RankEnum;

import java.util.List;

public interface MoneyProcessor {

    String calculateMargin(double beforeMoney, double afterMoney);

    Integer calculateLottoCount(Integer money);

    Integer calculateWinning(List<Integer> result, RankEnum rankEnum);
}
