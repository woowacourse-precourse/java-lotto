package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;

public class LottoNumberGenerator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int MAX_LENGTH = 6;

    public Lottos generateLottos(LottoCount lottoCount) {
        return generateLottoNumbers(lottoCount);
    }

    public Lottos generateLottoNumbers(LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();
        Lottos lottos = new Lottos();

        do {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, MAX_LENGTH);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.addLotto(lotto);
            count--;
        } while (count > 0);

        return lottos;
    }
}
