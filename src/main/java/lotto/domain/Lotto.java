package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ErrorMessage;

public class Lotto {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_SIZE.getErrorMessage());
        }
    }

    List<Integer> createRandomNumbers() {
        return pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTO_SIZE);
    }

    public void createLottoNumber() {
        Set<Integer> duplicate = new HashSet<>();
        while (duplicate.size() != LOTTO_SIZE) {
            duplicate.addAll(createRandomNumbers());
        }
        numbers.addAll(duplicate);
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
