package lotto.object;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        validate(numbers, bonusNumber);
        Collections.sort(numbers);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, Integer bonusNumber) {
        numberSizeValidate(numbers);
        numbersDuplicationValidate(numbers);
        numbersRangeValidate(numbers);
        bonusNumberValidate(bonusNumber);
    }

    private void numberSizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }

    private void numbersDuplicationValidate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() < 6) {
            throw new IllegalArgumentException("당첨 번호는 중복이 없어야 합니다.");
        }
    }

    private void numbersRangeValidate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호는 1~45 내의 수여야 합니다.");
            }
        }
    }

    private void bonusNumberValidate(Integer number) {

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
