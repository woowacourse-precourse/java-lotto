package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {

    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
