package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<List<Integer>> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    public void buy(int quantity) {
        for (int count = 0; count < quantity; count++) {
            lottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottos.get(count));
        }

    }
}
