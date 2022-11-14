package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public List<Lotto> lottoList = new ArrayList<>();
    private int purchaseAmount;
    private int lottoAmount;

    public LottoGame() {
        this.purchaseAmount = Input.EnterPurchaseAmount();
        this.lottoAmount = lottoAmount(purchaseAmount);
        makeLotto();
    }

    private int lottoAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return purchaseAmount / 1000;
    }

    private void makeLotto() {
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
    }
}
