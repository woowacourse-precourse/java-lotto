package lotto.domian.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> generateLotto(int count) {
        while (lottos.size() < count) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
