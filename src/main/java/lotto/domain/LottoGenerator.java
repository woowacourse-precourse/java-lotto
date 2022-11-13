package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Integer> createLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
