package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMaker {

    List<Lotto> lottos;

    public LottoMaker() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos(int many) {
        lottos.clear();
        for (int i = 0; i < many; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randoms);
    }
}
