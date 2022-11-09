package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    Computer() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
