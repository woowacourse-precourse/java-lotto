package lotto.domain;

import static lotto.utils.Validation.hasDuplicatedNumber;
import static lotto.utils.Validation.isNumbersInCorrectRange;
import static lotto.utils.Validation.isNumberInCorrectRnage;

import java.util.List;

public class WinningNumber {

    private List<Integer> numbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또에는 총 6개의 번호가 존재해야 합니다.");
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복되는 번호가 존재합니다.");
        }
        if (!isNumbersInCorrectRange(numbers) || !isNumberInCorrectRnage(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
