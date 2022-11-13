package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumbersGenerator {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int COUNT = 6;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
    }

}
