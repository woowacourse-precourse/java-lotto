package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static List<Integer> createSingleRandomLotto() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lotto);
        return lotto;

    }

    public static List<List<Integer>> createRandomLottos(int purchase) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < purchase; i++) {
            lottos.add(createSingleRandomLotto());
        }
        return lottos;
    }
}
