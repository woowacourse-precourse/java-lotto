package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {

    private List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
