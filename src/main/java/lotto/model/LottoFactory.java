package lotto.model;


import static lotto.constant.LottoConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public Lottos generateBy(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int count=0;count<lottoCount; count++){
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }

        return Lottos.of(lottos);
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_VALID_LOTTO_VALUE, MAX_VALID_LOTTO_VALUE, LOTTO_SIZE);
    }
}
