package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import util.exception.Valid;
import util.message.ErrorMessage;

public class Lotto {
    public static final int PER_PRICE_LOTTO=1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortAscend(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (Valid.hasDuplicateNum(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_NOT_DUPLICATE_NUM);
        }
        if (!Valid.isNumRangeLotto(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_LOTTO_RANGE_NUM);
        }
    }

    private void sortAscend(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public static List<Integer> generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
