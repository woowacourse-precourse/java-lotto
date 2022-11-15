package lotto.domain.buyer;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class User implements Buyer {

    private final List<Lotto> lottos;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public double calculateProfitRatio(int amount) {
        if (lottos.size() == 0) {
            return 0;
        }

        return (double) amount / (lottos.size() * 1000) * 100;
    }

    @Override
    public List<Lotto> getLottos() {
        return lottos;
    }
}
