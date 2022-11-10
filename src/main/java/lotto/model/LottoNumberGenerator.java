package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    private static final String UNIT = "1000";

    public Lottos generateLottos(Money money) {
        int lottoCount = money.calculateLottoCount(new Money(UNIT));
        return generateLottoNumbers(lottoCount);
    }

    public Lottos generateLottoNumbers(int lottoCount) {
        Lottos lottos = new Lottos();

        do {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.addLotto(lotto);
            lottoCount--;
        } while (lottoCount > 0);

        return lottos;
    }
}
