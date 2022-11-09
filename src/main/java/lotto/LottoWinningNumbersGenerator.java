package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoWinningNumbersGenerator {

    public static List<Integer> generateLottoWinningNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
