package lotto.object;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        validate(numbers, bonusNumber);

        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, Integer bonusNumber) {
        numberSizeValidate(numbers);
        numbersDuplicationValidate(numbers);
        numbersRangeValidate(numbers);
        bonusNumberRangeValidate(bonusNumber);
        bonusNumberDuplicateValidate(numbers, bonusNumber);
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

    private void bonusNumberRangeValidate(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 번호는 1~45 내의 수여야 합니다.");
        }
    }

    private void bonusNumberDuplicateValidate(List<Integer> numbers, Integer bonusNumber) {
        Set set = new HashSet(numbers);
        set.add(bonusNumber);

        if (set.size() != 7) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되어서는 안됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Integer getNumber(Integer index) {
        return numbers.get(index);
    }
}
