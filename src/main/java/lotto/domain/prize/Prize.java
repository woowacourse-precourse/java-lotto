package lotto.domain.prize;

import java.util.ArrayList;
import java.util.List;

public class Prize {
    private static final String INPUT_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.";
    private final List<Integer> numbers = new ArrayList<>();
    private final int bonusNumber;

    public Prize(String numbers, int bonusNumber) {
        //TODO: 입력 값에 대한 validation

        setNumbers(numbers);

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getPrize() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setNumbers(String input) {
        String[] numbers = input.split(",");

        for (String number : numbers) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            System.out.println(INPUT_BONUS_NUMBER_ERROR);
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_ERROR);
        }
    }
}
