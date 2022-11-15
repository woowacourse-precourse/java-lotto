package lotto;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static lotto.ErrorMessage.*;

public class Lotto {
    private final int LOTTO_NUMBERS_SIZE = 6;
    private final int NO_OUT_OF_RANGE_SIZE = 0;
    private final int LOTTO_NUMBER_FIRST_RANGE = 1;
    private final int LOTTO_NUMBER_LAST_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        checkLottoNumbersOverSize(numbers);
        checkLottoNumbersDuplicate(numbers);
        checkLottoNumbersRange(numbers);
    }

    private void checkLottoNumbersOverSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_SIZE_MESSAGE.getMessage());
        }
    }

    private void checkLottoNumbersDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> duplicateNumbers = new HashSet<>(numbers);

        if (numbers.size() != duplicateNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBERS_MESSAGE.getMessage());
        }
    }

    private void checkLottoNumbersRange(List<Integer> numbers) {
        List<Integer> outOfRange = numbers
                .stream().filter(number -> number > LOTTO_NUMBER_LAST_RANGE | number < LOTTO_NUMBER_FIRST_RANGE)
                .collect(Collectors.toList());

        if (outOfRange.size() != NO_OUT_OF_RANGE_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_RANGE.getMessage());
        }
    }

    public void printLottoNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(this.numbers);
        Collections.sort(sortedNumbers);
        System.out.println(Arrays.deepToString(sortedNumbers.toArray()));
    }

    public long getWinningNumberCount(List<Integer> winningNumbers) {
        long winningNumberCount = winningNumbers
                .stream().filter(old -> this.numbers.stream().anyMatch(Predicate.isEqual(old)))
                .count();
        return winningNumberCount;
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        boolean isContain = this.numbers.contains(bonusNumber);
        return isContain;
    }
}