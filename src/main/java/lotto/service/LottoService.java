package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.utils.Constants.*;
import static lotto.utils.Converter.convertToCountsOfLotto;

import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public static List<Lotto> generateLottoByPurchaseAmount(int purchaseAmount) {
        int lottoCount = convertToCountsOfLotto(purchaseAmount);

        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < lottoCount; count++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }

        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        return pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, COUNT_OF_NUMBERS_IN_LOTTO);
    }
}
