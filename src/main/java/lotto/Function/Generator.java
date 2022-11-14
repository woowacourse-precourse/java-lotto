package lotto.Function;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Generator {
    List<List<Integer>> result = new ArrayList<>();

    public Generator() {
    }

    public List<List<Integer>> makeNumbers(int num) {
        while (0 < num) {
            List<Integer> list = new ArrayList<>();
            list.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            list.sort(Comparator.naturalOrder());
            new Lotto(list);
            result.add(list);
            num--;
        }
        return result;
    }
}
