package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    
    public static final Integer START_NUMBER = 1;
    public static final Integer END_NUMBER = 45;
    public static final Integer NUMBER_COUNT = 6;
    
    public static List<Integer> randomLottoNumberList() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
    }
}
