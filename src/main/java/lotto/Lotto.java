package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int checkResult(List<Integer> winNumbers, Integer bonusNumber) {

    }

    public int compareWithWinNumbers(List<Integer> winNumbers) {
        int result = 0;
        for (Integer winNumber : winNumbers) {
            if (numbers.contains(winNumber)) {
                result++;
            }
        }
        return result;
    }

    public int compareWithBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    // TODO: 추가 기능 구현
}
