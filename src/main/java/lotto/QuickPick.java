package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class QuickPick {

    public static List<Integer> create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoState.START.number(), LottoState.END.number(), LottoState.LENGTH.number()
        );
        Collections.sort(numbers);
        return numbers;
    }
}
