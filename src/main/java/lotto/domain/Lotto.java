package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.view.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateLottoRange(numbers);
        this.numbers = numbers;
    }

    static List<Integer> createRandomNumbers() {
        return pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTO_SIZE);
    }

    public static Lotto createLotto() {
        Set<Integer> duplicate = new HashSet<>();
        while (duplicate.size() != LOTTO_SIZE) {
            duplicate.addAll(createRandomNumbers());
        }
        List<Integer> lotto = new ArrayList<>(duplicate);
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_SIZE.getErrorMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE.getErrorMessage());
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i > 45 || i < 1) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_RANGE.getErrorMessage());
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
