package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.ExceptionHandler;

public class NumberGenerator {

    ExceptionHandler exception = new ExceptionHandler();

    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        exception.createLottoNumberException(randomNumbers);

        randomNumbers = sortAscendingOrder(randomNumbers);
        return randomNumbers;
    }

    public List<Integer> sortAscendingOrder(List<Integer> object) {
        Collections.sort(object);
        return object;
    }
}
