package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private List<Lotto> lottos;

    public PurchasedLottos(int price) {
        
    }

    private void createLottos(int count) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottos.add(lotto);
        }
    }

    private List<Lotto> getLottos() {
        return this.lottos;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, 6);
    }
}
