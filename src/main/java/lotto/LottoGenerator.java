package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    List<Integer> numbers = new ArrayList<>();

    LottoGenerator() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
