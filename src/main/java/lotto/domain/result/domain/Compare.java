package lotto.domain.result.domain;

import java.util.List;

public class Compare {
    public final int sameNumberCnt;
    public final boolean isBonusSame;

    public Compare(List<Integer> numbers, List<Integer> lotto, int bonus) {
        sameNumberCnt = sameNumberCnt(numbers, lotto);
        isBonusSame = isBonusSame(numbers, bonus);
    }

    private int sameNumberCnt(List<Integer> numbers, List<Integer> lotto) {
        int sameNumberCnt = 0;
        for (int i = 0; i < lotto.size(); i++) {
            if (numbers.contains(lotto.get(i)))
                sameNumberCnt++;
        }
        return sameNumberCnt;
    }

    private boolean isBonusSame(List<Integer> numbers, int bonus) {
        return numbers.contains(bonus);
    }
}
