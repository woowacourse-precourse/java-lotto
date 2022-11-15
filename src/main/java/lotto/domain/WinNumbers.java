package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.LottoConstant;

public class WinNumbers {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinNumbers(List<Integer> numbers, int bonusNumber) {
        validateNumbers(numbers);
        validateBonusNumber(bonusNumber, numbers);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자만 입력 가능합니다.");
        }
        if (new HashSet<>(numbers).size() != LottoConstant.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException("당첨 번호는 중복된 숫자로 구성될 수 없습니다.");
        }
        for (int number : numbers) {
            validateNumber(number);
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호군에 속할 수 없습니다.");
        }
        validateNumber(bonusNumber);
    }

    private void validateNumber(int number) {
        if (number > LottoConstant.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(LottoConstant.MAX_NUMBER.getValue() + "보다 큰 값은 입력될 수 없습니다.");
        }
        if (number < LottoConstant.MIN_NUMBER.getValue()) {
            throw new IllegalArgumentException(LottoConstant.MIN_NUMBER.getValue() + "보다 낮은 값은 입력될 수 없습니다.");
        }
    }
}
