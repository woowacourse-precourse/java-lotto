package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        if (containsDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS);
        }
    }

    private boolean containsDuplicatedNumbers(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.size() != LOTTO_SIZE;
    }

    public Lotto creatRandom() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_SIZE);

        return new Lotto(uniqueNumbers);
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
