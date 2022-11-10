package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LotteryMachine {

    public static List<Integer> makeLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
