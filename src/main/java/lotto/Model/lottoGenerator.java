package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lottoGenerator {
    List<List<Integer>> groupLotto = new ArrayList<>();

    public List<List<Integer>> getGroupLotto(int amount) {
        for (int i =0; i<amount; i++) {
            groupLotto.add(generator());
        }
        return groupLotto;
    }

    public List<Integer> generator() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
