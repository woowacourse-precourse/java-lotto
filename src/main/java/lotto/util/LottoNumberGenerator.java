package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoNumberGenerator {
    public static final int START_IDX = 1;
    public static final int END_IDX = 45;
    public static final int NUMBER_COUNT = 6;

    public static List<Integer> generateLottoNumbers(){
        return pickUniqueNumbersInRange(START_IDX, END_IDX, NUMBER_COUNT);
    }
}
