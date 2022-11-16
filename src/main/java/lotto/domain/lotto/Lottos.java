package lotto.domain.lotto;

import java.util.List;
import lotto.exception.lotto.LottosEmptyException;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private void validate(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new LottosEmptyException();
        }
    }

    public List<Lotto> get() {
        return lottos;
    }
}


