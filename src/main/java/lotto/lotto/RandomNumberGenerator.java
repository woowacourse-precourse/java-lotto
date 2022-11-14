package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoManager.LOTTO_RANGE_START, LottoManager.LOTTO_RANGE_END, LottoManager.LOTTO_NUMBER_COUNT);
    }
}
