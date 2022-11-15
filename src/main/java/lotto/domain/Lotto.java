package lotto.domain;

import static lotto.constant.LottoRule.COUNT_OF_NUMBERS;
import static lotto.constant.LottoRule.END_NUMBER;
import static lotto.constant.LottoRule.START_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.ui.UserInterface;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        UserInterface.printLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        checkCountOfNumbers(numbers);
        checkRangeOfNumbers(numbers);
        checkDuplicationOfNumbers(numbers);
    }

    private static void checkCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() == COUNT_OF_NUMBERS) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.LOTTO_INCORRECT_COUNT);
    }

    private void checkRangeOfNumbers(List<Integer> numbers) {
        for (int number: numbers) {
            if (START_NUMBER <= number && number <= END_NUMBER) {
                continue;
            }
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INCORRECT_RANGE);
        }
    }

    private static void checkDuplicationOfNumbers(List<Integer> numbers) {
        Set<Integer> numbersDeleteDuplication = new HashSet<>(numbers);
        if (numbers.size() == numbersDeleteDuplication.size()) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATED_NUMBER);
    }

}
