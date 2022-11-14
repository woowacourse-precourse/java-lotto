package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> createLottos(int money) {
        List<Lotto> lottoList = new ArrayList<>();
        int amount = getAmountOfLottos(money);

        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
            lottoList.add(lotto);
        }

        return lottoList;
    }

    private int getAmountOfLottos(int money) {
        return money / 1000;
    }

    private List<Integer> createRandomNumbers() {
        return null;
    }
}
