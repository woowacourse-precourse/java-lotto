package lotto;

import java.util.List;

public class Buyer {
    private List<Lotto> lottos;

    public void buy(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
