package lotto;

import java.util.List;

public class Buyer {
    public List<Lotto> lottos;

    public void buy(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
