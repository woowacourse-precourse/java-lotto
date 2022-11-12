package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    static int LOTTO_PRICE = 1000;

    public Lottos(int paid) {
        List<Lotto> boughtLottos = new ArrayList<>();
        for (int i = 0; i < paid / LOTTO_PRICE; i++) {
            boughtLottos.add(Lotto.create());
        }
    }

    private void getScore(List<Integer> winningNumbers, int bonusNumber) {

    }
}
