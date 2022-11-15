package lotto;

import java.util.List;

public class Validator {

    public void validateLottoNumber(List<Integer> numbers) throws IllegalArgumentException {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    public void validateBonusNumber(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        validateRange(bonusNumber);
        validateDuplicate(numbers, bonusNumber);
    }

    private void validateSize(final List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
        }
    }

    private void validateRange(final List<Integer> numbers) throws IllegalArgumentException {
        for (int num : numbers) {
            if (num > 45 || num < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicate(final List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개는 서로 다른 숫자여야 합니다.");
        }
    }

    private void validateRange(final int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicate(final List<Integer> numbers, final int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 다른 숫자여야 합니다.");
        }
    }
}
