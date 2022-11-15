package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Code.ErrorCode.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.valueOf(LENGTH_MUST_BE_SIX));
        }
    }

    public static List<Integer> createLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
