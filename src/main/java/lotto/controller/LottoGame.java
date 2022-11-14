package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Constant;
import lotto.model.Lotto;
import lotto.view.LottoInputView;

public class LottoGame {
    private final LottoInputView lottoInputView;
    private final List<Lotto> lottos;

    public LottoGame() {
        this.lottoInputView = new LottoInputView();
        this.lottos = new ArrayList<>();
    }
    public void startLottoGame() {
        int userMoney = lottoInputView.getLottoAmount();
        issueLotto(userMoney);
    }

    public void issueLotto(int userMoney) {
        int lottoPaperCount = userMoney / 1000;
        for(int i = 0; i<lottoPaperCount; i++) {
            List<Integer> randomLottoNumbers = makeRandomLottoNumbers();
            Lotto newUserLotto = new Lotto(randomLottoNumbers);
            lottos.add(newUserLotto);
        }
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
