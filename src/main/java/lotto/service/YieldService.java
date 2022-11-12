package lotto.service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import lotto.constant.LottoResultConstant;

public class YieldService {
    public int calculateYield(Map<LottoResultConstant, Integer> result) {
        return result.keySet()
                .stream()
                .map(lottoResultConstant -> lottoResultConstant.getResultMoney() * result.get(lottoResultConstant))
                .reduce(Integer::sum)
                .get();

    }
}
