package lotto;

import lotto.domain.CreateStrategy;

import java.util.List;

public class ConstantCreateStrategy implements CreateStrategy {
    @Override
    public List<Integer> createTempLottoNumber() {
        return List.of(1,2,3,4,5,6);
    }
}
