package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.model.Constant;
import lotto.view.LottoInputView;

public class LottoController {
    private LottoInputView lottoInputView;

    public void start() {

    }

    private List<Integer> makeRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange
                (Constant.NUMBER_RANGE_START,
                        Constant.NUMBER_RANGE_END,
                        Constant.LOTTO_NUMBER_COUNT);
        sortLottoNumbers(randomNumbers);
        return randomNumbers;
    }

    private void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
