package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoPublishMachine {
    private static final int LOTTO_NUMBER_START_INCLUSIVE = 1;
    private static final int LOTTO_NUMBER_END_INCLUSIVE = 45;
    private static final int LOTTO_SIZE = 6;

    public static Lotto drawRandomLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START_INCLUSIVE,
                LOTTO_NUMBER_END_INCLUSIVE,
                LOTTO_SIZE
        );

        return new Lotto(lottoNumbers);
    }
}
