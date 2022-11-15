package lotto.service;

import static lotto.domain.Lotto.LOTTO_NUMBER_BEGIN;
import static lotto.domain.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.domain.Lotto.LOTTO_NUMBER_END;
import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.util.PrintService.printLottos;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    public List<Lotto> purchaseLottos(final int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int count = getPurchaseCount(purchaseAmount);
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        printLottos(lottos);
        return lottos;
    }

    public int getPurchaseCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private Lotto generateLotto() {
        List<Integer> uniqueNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
            LOTTO_NUMBER_BEGIN, LOTTO_NUMBER_END, LOTTO_NUMBER_SIZE));
        Collections.sort(uniqueNumbers);
        return new Lotto(uniqueNumbers);
    }

}
