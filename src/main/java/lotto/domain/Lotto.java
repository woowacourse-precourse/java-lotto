package lotto.domain;

import static lotto.utils.Constant.NUMBER_OF_LOTTO;

import java.util.HashSet;
import java.util.List;
import lotto.utils.ExceptionType;
import lotto.view.Output;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateBySize(numbers);
        validateNumbersByRange(numbers);
        validateByOverlap(numbers);
    }

    private void validateBySize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO) {
            Output.printErrorAndExit(ExceptionType.OVER_THAN_NUMBER_OF_LOTTO.getMessage());
            throw new IllegalArgumentException(ExceptionType.OVER_THAN_NUMBER_OF_LOTTO.getMessage());
        }
    }

    private void validateNumbersByRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberInLottoRange(number);
        }
    }

    private void validateNumberInLottoRange(int number) {
        if (number < 1 || number > 45) {
            Output.printErrorAndExit(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
            throw new IllegalArgumentException(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
        }
    }

    private void validateByOverlap(List<Integer> numbers) {
        HashSet<Integer> checkNumbers = new HashSet<>(numbers);

        if (checkNumbers.size() != NUMBER_OF_LOTTO) {
            Output.printErrorAndExit(ExceptionType.HAVE_OVERLAP.getMessage());
            throw new IllegalArgumentException(ExceptionType.HAVE_OVERLAP.getMessage());
        }
    }

    private void validateByOverlapForAddBonusNumber(int bonusNumber) {
        HashSet<Integer> checkNumbers = new HashSet<>(numbers);
        checkNumbers.add(bonusNumber);

        if (checkNumbers.size() != NUMBER_OF_LOTTO + 1) {
            Output.printErrorAndExit(ExceptionType.HAVE_OVERLAP.getMessage());
            throw new IllegalArgumentException(ExceptionType.HAVE_OVERLAP.getMessage());
        }
    }

    private void validateForBonusNumber(int number) {
        validateNumberInLottoRange(number);
        validateByOverlapForAddBonusNumber(number);
    }

    public void addBonusNumber(int number) {
        validateForBonusNumber(number);
        this.numbers.add(number);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            builder.append(numbers);
            if (i != numbers.size() - 1) {
                builder.append(", ");
            }
            if (i == numbers.size() - 1) {
                builder.append("]");
            }
        }

        return builder.toString();
    }
}
