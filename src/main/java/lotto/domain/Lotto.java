package lotto.domain;

import lotto.service.LottoService;
import lotto.ui.ExceptionMsg;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNum;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateScope(numbers);
        validateDuplicate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMsg.LOTTO_SIZE);
        }
    }

    private void validateScope(List<Integer> numbers) {
        boolean isException = numbers.stream()
                .anyMatch(number -> number < 1 || 45 < number);
        if (isException) {
            throw new IllegalArgumentException(ExceptionMsg.LOTTO_SCOPE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int nonDuplNum = (int) numbers.stream()
                .distinct().count();
        if (nonDuplNum != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMsg.LOTTO_DUPLICATE);
        }
    }

    private int getBonusNumbers() {
        return bonusNum;
    }

    public void addBonusNum(String bonusNum) {
        if (!LottoService.isOnlyNumbers(bonusNum)) {
            throw new IllegalArgumentException(ExceptionMsg.LOTTO_NUMBER);
        }
        int bonusNumber = Integer.parseInt(bonusNum);
        if (this.numbers.contains(bonusNumber) || bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException(ExceptionMsg.LOTTO_BONUS);
        }
        this.bonusNum = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int compare(Lotto target) {
        List<Integer> targetNumbers = target.getNumbers();
        int matchNum = (int) targetNumbers.stream()
                .filter(num -> this.numbers.contains(num))
                .count();
        return matchNum;
    }

    public boolean hasBonusNum(Lotto numbers) {
        bonusNum = numbers.getBonusNumbers();
        return this.numbers.contains(bonusNum);
    }
}
