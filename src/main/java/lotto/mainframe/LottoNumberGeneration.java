package lotto.mainframe;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGeneration {

    public static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
