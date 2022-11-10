package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class QuickPick {

    public static List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(
                LottoState.START.number(), LottoState.END.number(), LottoState.LENGTH.number()
        );
    }
}
