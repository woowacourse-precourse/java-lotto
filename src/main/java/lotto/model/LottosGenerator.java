package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottosGenerator {

    public static Lottos generate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.countLotto(); i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

    private static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
