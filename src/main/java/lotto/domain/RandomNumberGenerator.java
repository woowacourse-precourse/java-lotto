package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static final int lottoCnt = 6;
    List<Integer> lottoNums = new ArrayList<>();

    List<Integer> generateRandomNumber() {
        lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNums;
    }

}
