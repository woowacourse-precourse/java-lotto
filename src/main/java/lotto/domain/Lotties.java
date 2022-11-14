package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public final class Lotties {

    private final List<Lotto> lotties;

    private Lotties(int purchase) {
        lotties = new ArrayList<>();
        addLottoToList(purchase);
    }

    public static Lotties create(int purchase) {
        return new Lotties(purchase);
    }

    private void addLottoToList(int lottoCount) {
        IntStream.range(0, lottoCount)
                .forEach(x -> lotties.add(Lotto.create()));
    }

    public int count() {
        return lotties.size();
    }

    public List<Lotto> getLotties() {
        return Collections.unmodifiableList(lotties);
    }
}
