package domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.List;

public class Controller {
    public static List<Lotto> lottos;

    public static void lottoSpawner(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.get());
        }
    }

}

