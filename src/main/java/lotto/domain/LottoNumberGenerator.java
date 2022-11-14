package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {
    public static List<Lotto> createManyLotto(Integer lottoCount) {
        List<Lotto> Lottery = new ArrayList<>();
        for (Integer nowLottoCount = 0; nowLottoCount < lottoCount; ++nowLottoCount) {
            Lottery.add(createOneLotto());
        }

        return Lottery;
    }

    public static Lotto createOneLotto() {
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.addAll(Randoms.pickUniqueNumbersInRange(
            LottoNumberRule.LOTTO_MINIMUM_NUMBER.getValue(),
            LottoNumberRule.LOTTO_MAXIMUM_NUMBER.getValue(),
            LottoNumberRule.LOTTO_RANGE_SIZE.getValue()));
        return new Lotto(randomNumbers);
    }
}