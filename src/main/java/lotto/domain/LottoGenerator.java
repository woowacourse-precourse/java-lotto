package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateLotto(int purchaseAmt) {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoCount = purchaseAmt / 1000;

        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottoList;
    }
}
