package lotto.service;

import java.util.Map;
import lotto.constant.LottoResultConstant;

public class YieldService {
    public double calculateYield(Map<LottoResultConstant, Integer> result, int userMoney) {
        Integer earningMoney = result.keySet()
                .stream()
                .map(lottoResultConstant -> lottoResultConstant.getResultMoney() * result.get(lottoResultConstant))
                .reduce(Integer::sum)
                .get();

        return earningMoney * 100.0 / userMoney;
    }
}
