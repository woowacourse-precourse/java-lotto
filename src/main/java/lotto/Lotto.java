package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.INVALID_LIST.getMessage());
        }
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        if (hashSet.size() != 6) {
            throw new IllegalArgumentException(Error.INPUT_DUPLICATE.getMessage());
        }
        numbers.forEach((number -> {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException(Error.INVALID_INPUT_VALUE.getMessage());
            }
        }));
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public static Lotto createPurchaseLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
