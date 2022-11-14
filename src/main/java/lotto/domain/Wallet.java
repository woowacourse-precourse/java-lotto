package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.GameManager;
import lotto.utils.GameMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wallet {

    private List<Lotto> lottos;

    private int numberOfPurchase;

    public Wallet(int numberOfPurchase) {
        this.numberOfPurchase = numberOfPurchase;
        initialize();
        pickLottos();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
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

    public void printWallet() {
        System.out.printf("\n%d%s\n", numberOfPurchase, GameMessage.BUY_NUMBER_OF_LOTTO);
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public void initialize() {
        lottos = new ArrayList<>();
    }
}
