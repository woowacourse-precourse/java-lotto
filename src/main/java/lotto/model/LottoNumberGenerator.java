package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public Lottos generateLottos(Money money) {
        LottoCount lottoCount = new LottoCount(money);
        return generateLottoNumbers(lottoCount);
    }

    public Lottos generateLottoNumbers(LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();
        Lottos lottos = new Lottos();

        do {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.addLotto(lotto);
            count--;
        } while (count > 0);

        return lottos;
    }
}
