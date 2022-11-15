package lotto.domain;

import lotto.domain.strategy.CreateStrategy;

import java.util.List;

public class ConstantCreateStrategy implements CreateStrategy {
    @Override
    public List<LottoNumber> createTempLottoNumber() {
        return List.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2), LottoNumber.lottoNumber(3)
                , LottoNumber.lottoNumber(4), LottoNumber.lottoNumber(5), LottoNumber.lottoNumber(6));
    }
}
