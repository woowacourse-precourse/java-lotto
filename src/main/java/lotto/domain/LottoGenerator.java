package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.constant.Constant;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    public Lotto makeLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                Constant.MIN_LOTTO_NUMBER,
                Constant.MAX_LOTTO_NUMBER,
                Constant.LOTTO_SIZE);
        return new Lotto(sortLottoNumbers(lottoNumbers));
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().sorted().collect(Collectors.toList());
    }
}
