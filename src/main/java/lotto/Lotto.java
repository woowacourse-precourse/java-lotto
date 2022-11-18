package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Error.validateLottoNumSix(numbers);

        for (int index = 0; index < numbers.size(); index++) {
            Error.validateNotDuplicateLottoNum(numbers, index);
        }
        Error.validateNumIsInBoundary(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
