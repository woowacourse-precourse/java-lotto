package lotto.domain.prize;

import java.util.ArrayList;
import java.util.List;

public class Prize {
    private static final String PRIZE_NUMBER_FORMAT_ERROR = "[ERROR] 당첨 번호는 6개의 숫자와 ','로 구분되어야 합니다.";
    private static final String INPUT_NUMBER_RANGE_ERROR = "[ERROR] 숫자는 1~45까지의 정수여야 합니다.";
    private static final String DUPLICATED_NUMBER_ERROR = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String NOT_INTEGER_ERROR = "[ERROR] 정수 값이 입력되어야 합니다.";
    private final List<Integer> numbers = new ArrayList<>();
    private final int bonusNumber;

    public Prize(String numbers, String bonusNumber) {
        setNumbers(numbers);

        validateInteger(bonusNumber);
        validateNumberRange(Integer.parseInt(bonusNumber));
        validateDuplicatedNumber(Integer.parseInt(bonusNumber));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getPrize() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setNumbers(String input) {
        validateSixNumbers(input);

        String[] numbers = input.split(",");

        for (String number : numbers) {
            validateInteger(number);
            validateNumberRange(Integer.parseInt(number));
            validateDuplicatedNumber(Integer.parseInt(number));

            this.numbers.add(Integer.parseInt(number));
        }
    }

    private void validateInteger(String input) {
        String regex = "^[0-9]+$";

        if (!input.matches(regex)) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR);
        }
    }

    private void validateDuplicatedNumber(int number) {
        if (this.numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
        }
    }

    private void validateSixNumbers(String input) {
        String[] number = input.split(",");

        if (number.length != 6) {
            throw new IllegalArgumentException(PRIZE_NUMBER_FORMAT_ERROR);
        }
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR);
        }
    }
}
