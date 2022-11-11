package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Integer>[] createRandomNumbers(int count) {
        List<Integer>[] numbers = new List[count];
        for (int i = 0; i < count; i++) {
            List<Integer> number = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(number);
            numbers[i] = number;
        }
        return numbers;
    }
}
