package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberGenerator {
    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
