package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.LottoConstants;

public class LottoPublishMachine {

    public static Lotto drawRandomLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_NUMBER_MIN_RANGE,
                LottoConstants.LOTTO_NUMBER_MAX_RANGE,
                LottoConstants.LOTTO_SIZE
        );

        return new Lotto(lottoNumbers);
    }
}
