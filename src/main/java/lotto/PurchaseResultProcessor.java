package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class PurchaseResultProcessor {
    private static final int LOTTO_START_NUMBER_INCLUSIVE = 1;
    private static final int LOTTO_END_NUMBER_INCLUSIVE = 45;
    private static final int NUMBER_OF_PICKED_NUMBERS = 6;

    public int getPurchasedAmount(int totalPrice) {
        return totalPrice / 1000;
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
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }
}
