package lotto.controller.dto;

import static lotto.exception.ErrorMessage.*;
import static lotto.utils.Constant.SUBSTRING_STANDARD;

import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessage;
import lotto.exception.MyException;

public class WinnerNumberDto {

    private final List<Integer> winnerNumbers;
    private final int bonusNumber;

    public WinnerNumberDto(String winnerNumber, String bonusNumber) {
        this.winnerNumbers = checkWinnerNumber(winnerNumber);
        this.bonusNumber = checkBonusNumber(bonusNumber);
    }

    private List<Integer> checkWinnerNumber(String winnerNumber) {
        List<String> winnerNumbers = convertStringToList(winnerNumber, SUBSTRING_STANDARD);
        for (String number : winnerNumbers) {
            validInteger(number);
        }
        List<Integer> numbers = convertStringListToInterList(winnerNumbers);
        for (Integer number : numbers) {
            validWinnerNumberRange(number);
        }
        validDuplication(numbers);
        return numbers;
    }

    private static List<Integer> convertStringListToInterList(List<String> winnerNumbers) {
        return winnerNumbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private void validDuplication(List<Integer> numbers) {
        boolean hasDuplicationNumber = numbers.stream()
                .distinct()
                .count() != numbers.size();
        if (hasDuplicationNumber) {
            throw new MyException(LOTTO_DUPLICATION);
        }
    }

    private void validWinnerNumberRange(int winnerNumber) {
        if (!ValueRange.of(1, 45).isValidValue(winnerNumber)) {
            throw new MyException(LOTTO_NOT_IN_RAGE);
        }
    }

    private static List<String> convertStringToList(String winnerNumber, String standard) {
        return Arrays.stream(winnerNumber.split(standard))
                .collect(Collectors.toList());
    }

    private int checkBonusNumber(String bonusNumber) {
        validInteger(bonusNumber);
        int number = Integer.parseInt(bonusNumber);
        validDuplicationWinnerNumber(number);
        validBonusNumberRange(number);
        return number;
    }

    private void validBonusNumberRange(int bonusNumber) {
        if (!ValueRange.of(1, 45).isValidValue(bonusNumber)) {
            throw new MyException(LOTTO_BONUS_NOT_IN_RAGE);
        }
    }

    private void validDuplicationWinnerNumber(int number) {
        if (this.winnerNumbers.contains(number)) {
            throw new MyException(LOTTO_BONUS_DUPLICATION);
        }
    }

    private void validInteger(String numbers) {
        boolean isInteger = numbers.chars()
                .allMatch(Character::isDigit);
        if (!isInteger) {
            throw new MyException(LOTTO_NOT_INTEGER);
        }
    }

    public List<Integer> getWinnerNumbers() {
        return this.winnerNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
