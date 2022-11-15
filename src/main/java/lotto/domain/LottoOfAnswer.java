package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoOfAnswer {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public LottoOfAnswer(List<Integer> numbers, int bonusNumber) {
        validate(numbers,bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers,int bonusNumber) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateBonusNumber(numbers, bonusNumber);
    }


    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> distinct = new HashSet<>(numbers);
        if (distinct.size() != 6) {
            throw new IllegalArgumentException("로또는 중복된 숫자를 허용되지 않습니다.");
        }
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호에 보너스 번호가 들어갈 수 없습니다.");
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
