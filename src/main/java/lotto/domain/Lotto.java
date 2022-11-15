package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.util.LottoUtils;
import lotto.view.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        checkUniqueNumbers(numbers);
        for (Integer number : numbers) {
            checkNumberInRange(number);
        }
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.inputNumberSizeError();
            throw new IllegalArgumentException();
        }
    }

    public void checkUniqueNumbers(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != uniqueNumbers.size()) {
            ExceptionMessage.overlabNumberError();
            throw new IllegalArgumentException();
        }
    }

    public void checkNumberInRange(Integer number) {
        LottoUtils.checkNumberInRange(number);
    }

    public LottoGrade getLottoGrade(WinningLotto winningLotto) {
        int correctCount = compareToWinningLotto(winningLotto);
        boolean correctBonus = compareToBonusNumber(winningLotto);

        return LottoGrade.getGrade(correctCount, correctBonus);
    }

    public int compareToWinningLotto(WinningLotto winningLotto) {
        return (int) winningLotto.getNumbers().stream()
                .filter(number -> numbers.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();

    }

    public boolean compareToBonusNumber(WinningLotto winningLotto) {
        return numbers.contains(winningLotto.getBonusNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
