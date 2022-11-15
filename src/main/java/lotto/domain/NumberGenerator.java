package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        // ErrorHandler#createLottoNumberError(randomNumbers);
        randomNumbers = sortAscendingOrder(randomNumbers);
        return randomNumbers;
    }

    public List<Integer> sortAscendingOrder(List<Integer> object) {
        Collections.sort(object);
        return object;
    }
}
