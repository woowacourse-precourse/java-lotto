package lotto.service;

import java.util.Map;
import lotto.constant.LottoResultConstant;
import lotto.domain.Money;

public class YieldService {

    public static double calculateYield(Map<LottoResultConstant, Integer> result, Money userMoney) {
        Integer earningMoney = result.keySet()
                .stream()
                .map(lottoResultConstant -> lottoResultConstant.getResultMoney() * result.get(lottoResultConstant))
                .reduce(Integer::sum)
                .orElse(0);

        return userMoney.yield(earningMoney);
    }

}
