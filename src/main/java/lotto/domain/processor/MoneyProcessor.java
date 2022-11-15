package lotto.domain.processor;

import lotto.domain.enummodel.RankEnum;

import java.util.List;

public interface MoneyProcessor {

    /**
     * 마진을 계산해주는 로직
     * @param beforeMoney - 원금
     * @param afterMoney - 수익
     * @return 마진률
     */
    String calculateMargin(double beforeMoney, double afterMoney);

    /**
     * 현재 금액으로 몇개의 로또를 살 수 있는지 확인하는 로직
     * @param money - 현재 금액
     * @return 살 수 있는 로또의 수
     */
    Integer calculateLottoCount(Integer money);

    /**
     * 당첨금을 계산하는 로직
     * @param result - 당첨 카운트가 들어있는 리스트
     * @param rankEnum - 당첨등수
     * @return 리스트에 당첨등수가 몇개있는지 확인 후 해당 당첨등수의 금액을 리턴한다.
     */
    Integer calculateWinning(List<Integer> result, RankEnum rankEnum);
}
