package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoCreateStrategy implements CreateStrategy {
    @Override
    public List<Integer> createTempLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
