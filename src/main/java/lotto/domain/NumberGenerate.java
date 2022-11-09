package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerate {
    public List<Integer> createRandom() {
        List<Integer> drawnNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return drawnNumbers;
    }
}
