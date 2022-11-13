package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    List<Integer> numbers = new ArrayList<>();

    LottoGenerator() {
        List<Integer> tmp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for (int i = 0; i < tmp.size(); i++) {
            numbers.add(tmp.get(i));
        }
        Collections.sort(numbers);

    }

}
