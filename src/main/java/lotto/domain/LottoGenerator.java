package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBERS_SIZE = 6;

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE);
    }
}
