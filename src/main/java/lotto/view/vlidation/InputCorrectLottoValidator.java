package lotto.view.vlidation;

import lotto.domain.LottoConfig;
import lotto.view.exception.CantBlankOrNullInputException;
import lotto.view.exception.CantDuplicatedNumberInputException;
import lotto.view.exception.NumberIsOutOfRange;
import lotto.view.exception.OnlySixNumberInputException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static lotto.domain.LottoConfig.*;

public class InputCorrectLottoValidator {

    public static void validate(List<Integer> inputNumbers) {
        validateNumberListInRange(inputNumbers);
        validateNumbersLength(inputNumbers);
        validateNoDuplicateNumbers(inputNumbers);
    }

    private static void validateNumberListInRange(List<Integer> inputNumbers) {
        for (Integer integer : inputNumbers) {
            if (!isNumberInRange(integer)) {
                throw new NumberIsOutOfRange();
            }
        }
    }

    public static boolean isNumberInRange(int number) {
        return (number >= MIN_NUMBER.getNumber()) && (number <= MAX_NUMBER.getNumber());
    }

    private static void validateNoDuplicateNumbers(List<Integer> inputNumbers) {
        HashSet<Integer> inputNoDuplicatedNumbers = (HashSet<Integer>) Set.copyOf(inputNumbers);
        if (inputNoDuplicatedNumbers.size() != inputNumbers.size()){
            throw new CantDuplicatedNumberInputException();
        }
    }

    private static void validateNumbersLength(List<Integer> userNumbers) {
        if (userNumbers.size() != MAX_LENGTH.getNumber()) {
            throw new OnlySixNumberInputException();
        }
    }

}
