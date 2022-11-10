package lotto.domain;

import java.util.List;

public class Buyer {

    private List<Lotto> lottos;
    public static Buyer newInstance() {
        return new Buyer();
    }

    public void buy(List<Integer> lotto) {
        lottos.add(Lotto.from(lotto));
    }
}
