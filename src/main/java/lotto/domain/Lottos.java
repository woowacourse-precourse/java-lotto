package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int money) {
        int issuedCount = money / LOTTO_PRICE;
        for (int i = 0; i < issuedCount; i++) {
            lottos.add(Lotto.creatRandom());
        }
    }

    public int countTotal() {
        return lottos.size();
    }
}
