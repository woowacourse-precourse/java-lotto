package lotto.caculation;

import lotto.reward.Lotto;
import lotto.reward.RandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class Purchase { //로또 구매 함수
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lotto;

    public Purchase(int money) {
        lotto = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lotto.add(new Lotto(new RandomNumbers()));
        }
    }

    public List<Lotto> getLottoList(){
        return lotto;
    }
}
