package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.status.lotto.LottoStatus;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> getLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LottoStatus.startInclusive.getValue(),
                    LottoStatus.endInclusive.getValue(), LottoStatus.count.getValue())));
        }

        return lottos;
    }
}
