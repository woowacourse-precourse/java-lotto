package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class NumbersGenerator {

    private final List<Integer> numbers;

    public NumbersGenerator() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
