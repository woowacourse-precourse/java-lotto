package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> getLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<quantity; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottos;
    }
}
