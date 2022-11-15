package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.NumberGenerator;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;
    NumberGenerator numberGenerator;

    public WinningNumbers(List<String> numbers, int bonusNumber) {
        numberGenerator = new NumberGenerator();
        this.numbers = numberGenerator.createWinningNumbers(numbers);
        validate(this.numbers);
        checkOverlap(this.numbers);
        checkScope(this.numbers);
        this.bonusNumber = numberGenerator.createBonusNumbers(this.numbers, bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("입력한 숫자 개수가 6개가 아닙니다.");
        }
    }

    public void checkOverlap(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (distinctNumbers.size() < 6) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public void checkScope(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("1부터 45사이의 숫자를 입력하세요.");
            }
        }
    }
}
