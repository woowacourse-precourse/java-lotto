package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    
    public static List<Integer> randomLottoNumberList() {
        return Randoms.pickUniqueNumbersInRange(LottoNumberEnum.START_NUMBER.getValue(),
                LottoNumberEnum.END_NUMBER.getValue(),
                LottoNumberEnum.NUMBER_COUNT.getValue());
    }
}
