package lotto.view.vlidation;

import lotto.view.exception.CantDuplicatedNumberInputException;
import lotto.view.exception.NumberIsOutOfRangeException;
import lotto.view.exception.OnlySixNumberInputException;

import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoConfig.*;

public class InputCorrectLottoValidator {

    private InputCorrectLottoValidator() {
    }

    public static void validate(List<Integer> inputNumbers) {
        try {
            validateNumberListInRange(inputNumbers);
            validateNumbersLength(inputNumbers);
            validateNoDuplicateNumbers(inputNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validateNumberListInRange(List<Integer> inputNumbers) {
        for (Integer integer : inputNumbers) {
            if (!isNumberInRange(integer)) {
                throw new NumberIsOutOfRangeException();
            }
        }
    }

    public static boolean isNumberInRange(Integer number) {
        return (number >= MIN_NUMBER.getNumber()) && (number <= MAX_NUMBER.getNumber());
    }

    private static void validateNoDuplicateNumbers(List<Integer> inputNumbers) {
        HashSet<Integer> inputNoDuplicatedNumbers = new HashSet<>(inputNumbers);
        if (inputNoDuplicatedNumbers.size() != inputNumbers.size()) {
            throw new CantDuplicatedNumberInputException();
        }
    }

    private static void validateNumbersLength(List<Integer> userNumbers) {
        if (userNumbers.size() != MAX_LENGTH.getNumber()) {
            throw new OnlySixNumberInputException();
        }
    }

}
