package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {
    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
