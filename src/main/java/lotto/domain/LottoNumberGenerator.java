package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int RANGE_NUMBER = 6;

    public static List<Lotto> createManyLotto(Integer lottoCount) {
        List<Lotto> Lottery = new ArrayList<>();
        for (Integer nowLottoCount = 0; nowLottoCount < lottoCount; ++nowLottoCount) {
            Lottery.add(createOneLotto());
        }

        return Lottery;
    }

    public static Lotto createOneLotto() {
	return new Lotto(Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, RANGE_NUMBER));
    }
}