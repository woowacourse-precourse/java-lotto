package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> lottoSet = new HashSet<>(numbers);
        if (lottoSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


    // TODO: 추가 기능 구현
    public Lotto makeLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size()!=6) {
            int number = Randoms.pickNumberInRange(1,45);

            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return new Lotto(numbers);
    }
}
