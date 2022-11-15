package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.util.LottoUtils;
import lotto.view.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkUniqueNumbers(numbers);
        checkNumberInRanger(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.inputNumberSizeError();
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
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

    public void checkNumberInRanger(List<Integer> numbers) {
        for(Integer number : numbers){
            LottoUtils.checkNumberInRange(number);
        }
    }

    public LottoGrade getLottoGrade(WinningLotto winningLotto) {
        int correct = compareToWinningLotto(winningLotto);
        boolean bonus = compareToBonusNumber(winningLotto);

        return LottoGrade.getGrade(correct, bonus);
    }

    public int compareToWinningLotto(WinningLotto winningLotto) {
        int result = (int) winningLotto.getNumbers().stream()
                .filter(number -> getNumbers().stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
        return result;
    }

    public boolean compareToBonusNumber(WinningLotto winningLotto) {
        return getNumbers().contains(winningLotto.getBonusNumber());
    }
}
