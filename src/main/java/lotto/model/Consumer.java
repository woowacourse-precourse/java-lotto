package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private final List<Lotto> lottos;

    public Consumer(){
        lottos = new ArrayList<>();
    }

    public Consumer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private int divideMoneyIntoLottoPrice(int money){
        return money / 1000;
    }
}
