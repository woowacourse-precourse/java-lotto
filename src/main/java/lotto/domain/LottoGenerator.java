package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.constant.Constant;
import java.util.List;

public class LottoGenerator {
    public Lotto makeLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                Constant.MIN_LOTTO_NUMBER,
                Constant.MAX_LOTTO_NUMBER,
                Constant.LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }
}
