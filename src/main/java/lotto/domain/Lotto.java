package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.ErrorMessage;
import lotto.utils.Numbers;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Numbers.sortAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        if (containsDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS);
        }
        if (isNumbersOutOfRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_OUT_OF_RANGE);
        }
    }

    private boolean containsDuplicatedNumbers(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.size() != LOTTO_SIZE;
    }

    private boolean isNumbersOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto creatRandom() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);

        return new Lotto(uniqueNumbers);
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(number -> winningLotto.contains(number))
                .count();
    }

    public LottoResult getResult(Lotto winningLotto, int bonusNumber) {
        int sameCount = countMatchingNumbers(winningLotto);
        boolean containsBonusNumber = contains(bonusNumber);

        return LottoResult.of(sameCount, containsBonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
