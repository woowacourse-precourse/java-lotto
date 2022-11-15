package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getMessage());
        }
        if (!checkUniqueNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getMessage());
        }
        for (int number : numbers) {
            checkRange(number);
        }
    }

    private static boolean checkUniqueNumber(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        return numbers.size() == checkNumbers.size();
    }

    private void checkRange(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getPrized(List<Integer> luckyNumbers, int bonusNumbers) {
        Judgement judgement = new Judgement();
        return judgement.getRanking(numbers, luckyNumbers, bonusNumbers);
    }
}
