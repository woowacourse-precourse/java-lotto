package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> numbers = null;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public Integer countEqualLottoNumber(List<Integer> luckyNumbers) {
        int count = 0;
        for (Integer luckyNumber : luckyNumbers) {
            if (checkEqual(luckyNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean checkEqual(Integer luckyNumber) {
        for (Integer number : numbers) {
            if (number == luckyNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean isEqualBonusNumber(Integer bonusNumber) {
        for (Integer number : numbers) {
            if (number == bonusNumber) {
                return true;
            }
        }

        return false;
    }
}
