package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.LottoNumberCreator.*;

public class Consumer {
    public static final int WON = 1000;

    private int money = 0;
    private final List<Lotto> lottos = new ArrayList<>();

    public Consumer(int money) {
        this.money = money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void createLottos() {
        int lottoAmount = divideMoneyIntoLottoPrice();

        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
            this.lottos.add(lotto);
        }
    }

    public int divideMoneyIntoLottoPrice() {
        return money / WON;
    }
}
