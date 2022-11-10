package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

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

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (hasNumber(i, numbers.get(i), numbers)) {
                throw new IllegalArgumentException();
            }
        }
    }

    /* 중복검사 */
    private boolean hasNumber(int indexNumber, int number, List<Integer> numbers) {
        for (int j = indexNumber + 1; j < numbers.size(); j++) {
            if (numbers.get(j) == number) {
                return true;
            }
        }
        return false;
    }


    // TODO: 추가 기능 구현
}
