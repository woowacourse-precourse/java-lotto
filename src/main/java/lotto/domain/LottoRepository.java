package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoRepository {

    public Lotto create() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoEnum.LOTTO.getMinNum(), LottoEnum.LOTTO.getMaxNum(), LottoEnum.LOTTO.getSize()));
    }
}
