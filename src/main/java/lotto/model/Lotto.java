package lotto.model;

import static lotto.constant.LottoConstants.DUPLICATE_NUMBER_EXIST_MSG;
import static lotto.constant.LottoConstants.INVALID_LOTTO_SIZE_MSG;
import static lotto.constant.LottoConstants.INVALID_RANGED_LOTTO_MSG;
import static lotto.constant.LottoConstants.LOTTO_SIZE;
import static lotto.constant.LottoConstants.MAX_VALID_LOTTO_VALUE;
import static lotto.constant.LottoConstants.MIN_VALID_LOTTO_VALUE;
import static lotto.constant.LottoConstants.TO_STRING;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    public int countContainedNumbersIn(Lotto another) {
        return (int) this.numbers.stream()
                .filter(number -> another.numbers.contains(number))
                .count();
    }

    public boolean contains(BonusBall bonusBall) {
        if (this.numbers.contains(bonusBall.getValue())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return TO_STRING + this.numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidSize(numbers);
        hasDuplicateNumber(numbers);
        isInProperRange(numbers);
    }

    private void isValidSize(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MSG);
        }
    }

    private void hasDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST_MSG);
        }
    }

    private void isInProperRange(List<Integer> numbers) {
        if (numbers.stream()
                .filter(number -> MIN_VALID_LOTTO_VALUE <= number && number <= MAX_VALID_LOTTO_VALUE)
                .count() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_RANGED_LOTTO_MSG);
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
