package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class UserLottoNumbers {
    private final Lotto lotto;

    public UserLottoNumbers() {
        List<Integer> lottoNumbers = makeRandomLottoNumbers();
        sortLottoNumbers(lottoNumbers);
        this.lotto = new Lotto(lottoNumbers);
    }

    private List<Integer> makeRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange
                (Constant.NUMBER_RANGE_START,
                        Constant.NUMBER_RANGE_END,
                        Constant.LOTTO_NUMBER_COUNT);
        return randomNumbers;
    }

    private void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
