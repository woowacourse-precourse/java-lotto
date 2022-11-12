package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class Lotties {

    private final List<Lotto> lotties;

    private Lotties(int lottoCount) {
        lotties = new ArrayList<>();
        addLottoToList(lottoCount);
    }

    public static Lotties create(int lottoCount) {
        return new Lotties(lottoCount);
    }

    private void addLottoToList(int lottoCount) {
        for (int i = 0 ; i < lottoCount ; i++) {
            lotties.add(Lotto.create());
        }
    }
}
