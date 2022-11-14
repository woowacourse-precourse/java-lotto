package lotto.Function;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Generator {
    private final List<List<Integer>> result;

    public Generator(List<List<Integer>> result) {
        this.result = result;
    }

    public List<List<Integer>> makeNumbers(int num) {
        while (0 < num) {
            result.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            num--;
        }
        return result;
    }

}
