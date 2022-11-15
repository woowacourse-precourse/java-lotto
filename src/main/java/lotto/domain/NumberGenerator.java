package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private final List<Integer> numbers;

    public NumberGenerator(int start, int end, int count) {
        numbers = Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
