package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static final int lottoCnt = 6;
    private Lotto lotto;

    List<Integer> generateRandomNumber() {
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto = new Lotto(lottoNums);
        }
        return lotto.getNumbers();
    }

}
