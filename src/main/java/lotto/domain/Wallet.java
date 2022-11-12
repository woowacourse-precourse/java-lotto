package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private List<Lotto> lottos;

    private int numberOfPurchase;

    public Wallet(int numberOfPurchase) {
        this.numberOfPurchase = numberOfPurchase;
        initialize();
        pickLottos();
    }

    private void pickLottos() {
        for (int i = 0; i < numberOfPurchase; i++) {
            lottos.add(pickRandomNumber());
        }
    }

    private Lotto pickRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void initialize() {
        lottos = new ArrayList<>();
    }
}
