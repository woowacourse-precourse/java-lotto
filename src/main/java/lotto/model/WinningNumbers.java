package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.NumberGenerator;

public class WinningNumbers {
    private static final int MAX = 45;
    private static final int MIN = 1;
    private static final int WINNGNUMBERSIZE = 6;

    private final List<Integer> numbers;
    private final int bonusNumber;
    private NumberGenerator numberGenerator;

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
        if (numbers.size() != WINNGNUMBERSIZE) {
            throw new IllegalArgumentException("입력한 숫자 개수가 6개가 아닙니다.");
        }
    }

    public void checkOverlap(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (distinctNumbers.size() < WINNGNUMBERSIZE) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public void checkScope(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN || number > MAX) {
                throw new IllegalArgumentException("1부터 45사이의 숫자를 입력하세요.");
            }
        }
    }
}
