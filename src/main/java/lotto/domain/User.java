package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class User {

    private int lottoCount;
    private List<Lotto> lottos = new ArrayList<>();

    public User(int purchase) {
        this.lottoCount = purchase / 1000;
    }

    public void createLottos() {
        for (int repeat = 0; repeat < lottoCount; repeat++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
