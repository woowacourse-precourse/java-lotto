package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private static final int AMOUNT_PER_LOTTO = 1_000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int lottoPurchasedAmount) {
        int lottoCount = lottoPurchasedAmount / AMOUNT_PER_LOTTO;
        List<Lotto> lottos = new ArrayList<>(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoDrawer.drawRandomLotto());
        }

        return new Lottos(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public Stream<Lotto> lottoStream() {
        return lottos.stream();
    }
}
