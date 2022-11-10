package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    
    public static List<Integer> randomLottoNumberList() {
        return Randoms.pickUniqueNumbersInRange(LottoNumberConstant.START_NUMBER, LottoNumberConstant.END_NUMBER,
                LottoNumberConstant.NUMBER_COUNT);
    }
}
