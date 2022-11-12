package lotto.domain;

import java.util.List;

public class ConstantCreateStrategy implements CreateStrategy {
    @Override
    public List<LottoNumber> createTempLottoNumber() {
        return List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }
}
