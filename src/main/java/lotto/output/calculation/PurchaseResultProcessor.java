package lotto.output.calculation;

import lotto.data.Lotto;
import lotto.data.PurchaseResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class PurchaseResultProcessor {
    private static final int LOTTO_UNIT_PRICE = 1000;
    private static final int LOTTO_START_NUMBER_INCLUSIVE = 1;
    private static final int LOTTO_END_NUMBER_INCLUSIVE = 45;
    private static final int NUMBER_OF_PICKED_NUMBERS = 6;

    public PurchaseResult getPurchaseResult(int totalPrice) {
        int purchasedAmount = getPurchasedAmount(totalPrice);
        List<Lotto> purchasedLottos = getLottos(purchasedAmount);

        return new PurchaseResult(purchasedAmount, purchasedLottos);
    }

    public int getPurchasedAmount(int totalPrice) {
        return totalPrice / LOTTO_UNIT_PRICE;
    }

    public List<Lotto> getLottos(int purchasedAmount) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        int count = 0;

        while (count < purchasedAmount) {
            Lotto lotto = issueNewLotto();
            lottos.add(lotto);
            count++;
        }

        return lottos;
    }

    private Lotto issueNewLotto() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(
                LOTTO_START_NUMBER_INCLUSIVE, LOTTO_END_NUMBER_INCLUSIVE, NUMBER_OF_PICKED_NUMBERS
        );

        List<Integer> sortedRandomNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortedRandomNumbers);

        return new Lotto(sortedRandomNumbers);
    }
}
