package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerate {
    public static List<Integer> createRandom() {
        List<Integer> userLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return userLottoNumbers;
    }
}
