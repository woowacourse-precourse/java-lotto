package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {

    private static final Integer UNIT_AMOUNT = 1000;

    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Integer getNumberOfLotto(Integer purchaseAmount) {
        return (purchaseAmount / UNIT_AMOUNT);
    }
}
