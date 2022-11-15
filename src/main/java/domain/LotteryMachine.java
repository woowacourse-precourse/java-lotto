package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryMachine {
    private final List <Lotto> lottos = new ArrayList <>();

    public LotteryMachine(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }
    }

    private Lotto createLotto() {
        List <Integer> newLotto = new ArrayList <>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return new Lotto(newLotto);
    }

    public List <Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
