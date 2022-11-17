package lotto;

import java.util.HashSet;
import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        validateNumbers(numbers);
        this.numbers = numbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


    private void validateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개이여야 합니다.");
        }
        for (int number : numbers) {
            validateNumberRange(number);
        }
        validateDuplication(numbers);
    }

    protected void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("로또 번호는 모두 달라야 합니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) throws IllegalArgumentException {
        validateNumberRange(bonusNumber);
        List<Integer> numbers = this.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 모두 달라야 합니다.");
        }
    }

}
