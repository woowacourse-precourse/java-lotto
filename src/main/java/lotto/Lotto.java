package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
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

    public List<Integer> crateRandomLottoNumber() {
        List<Integer> createdRandomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(createdRandomNumbers);

        return createdRandomNumbers;
    }
}
