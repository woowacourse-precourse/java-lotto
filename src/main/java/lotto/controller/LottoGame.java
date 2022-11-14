package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.utils.Constants.*;
import static lotto.utils.Converter.convertToCountsOfLotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGame {

    public List<Lotto> generateLottoByPurchaseAmount(int purchaseAmount) {
        int lottoCount = convertToCountsOfLotto(purchaseAmount);

        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < lottoCount; count++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }

        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        return pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, COUNT_OF_NUMBERS_IN_LOTTO);
    }
}
