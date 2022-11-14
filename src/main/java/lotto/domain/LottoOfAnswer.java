package lotto.domain;

import java.util.List;

public class LottoOfAnswer {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public LottoOfAnswer(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        validateLottoOfAnswer(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoOfAnswer(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호에 보너스 번호는 들어갈 수 없습니다.");
        }
    }

    public int ifContainThenCountAdd(Integer number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean isContainBounus(boolean isNotExistBonus, Integer number) {
        if (isNotExistBonus) {
            return bonusNumber == number;
        }
        return true;
    }
}
