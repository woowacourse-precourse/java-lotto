package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> createSortedLottoNumbers(int count) {
        final int LOTTO_START_NUMBER = 1;
        final int LOTTO_END_NUMBER = 45;

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, count);
        lottoNumbers.sort(null);

        return lottoNumbers;
    }
}
