package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {

    private static final int LOTTO_NUMBER_CAPACITY = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    List<Integer> numbers = new ArrayList<>();

    private Store() {
    }

    public List<Integer> drawNumber() {

        numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_CAPACITY);
        Collections.sort(numbers);

        return numbers;

    }

    public void showLotto() {
    }

}
