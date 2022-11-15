package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private NumberGenerator generator;

    public LottoShop() {
        generator = new NumberGenerator();
    }

    public List<Lotto> purchase(Ticket ticket) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticket.getCount(); i++) {
            lottos.add(new Lotto(generator.createRandomNumbers()));
        }
        return lottos;
    }
}
