package lotto.controller.dto;

import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerNumberDto {

    public static final String STANDARD = ",";
    private final List<Integer> winnerNumbers;
    private final int bonusNumber;

    public WinnerNumberDto(String winnerNumber, String bonusNumber) {
        this.winnerNumbers = checkWinnerNumber(winnerNumber);
        this.bonusNumber = checkBonusNumber(bonusNumber);
    }

    private List<Integer> checkWinnerNumber(String winnerNumber) {
        List<String> winnerNumbers = convertStringToList(winnerNumber, STANDARD);
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
            throw new IllegalArgumentException("[ERROR] 당첨번호 안에서 중복 숫자가 있습니다.");
        }
    }

    private void validWinnerNumberRange(int winnerNumber) {
        if (!ValueRange.of(1, 45).isValidValue(winnerNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 1 ~ 45 범위안에 포함되지 않습니다.");
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
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 1 ~ 45 범위안에 포함되지 않습니다.");
        }
    }

    private void validDuplicationWinnerNumber(int number) {
        if (this.winnerNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨번호와 중복되면 안됩니다.");
        }
    }

    private void validInteger(String numbers) {
        boolean isInteger = numbers.chars()
                .allMatch(Character::isDigit);
        if (!isInteger) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 정수값이 아닌 값이 포함되어 있습니다.");
        }
    }
}
