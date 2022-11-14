package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;

public class Publish {
    private final List<List<Integer>> lottos;
    public Publish(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int n = 0; n < count; n++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers).getNumbers());
        }
        this.lottos = lottos;
    }
    public List<List<Integer>> getLottos() {
        return this.lottos;
    }
}
