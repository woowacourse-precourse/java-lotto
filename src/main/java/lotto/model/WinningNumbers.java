package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.NumberGenerator;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;
    NumberGenerator numberGenerator;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        numberGenerator = new NumberGenerator();
        validate(numbers);
        checkOverlap(numbers);
        checkScope(numbers);
        this.numbers = numbers;
        this.bonusNumber = numberGenerator.createBonusNumbers(numbers, bonusNumber);

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

    private void checkOverlap(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        validate(distinctNumbers);
    }

    public void checkScope(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("1부터 45사이의 숫자를 입력하세요.");
            }
        }
    }
}
