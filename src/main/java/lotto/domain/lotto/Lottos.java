package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.common.LottoConstants;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int lottoPurchasedAmount) {
        int lottoCount = lottoPurchasedAmount / LottoConstants.AMOUNT_PER_LOTTO;
        List<Lotto> lottos = new ArrayList<>(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoPublishMachine.drawRandomLotto());
        }

        return new Lottos(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public Stream<Lotto> lottoStream() {
        return lottos.stream();
    }

    public int purchasedLottosAmount() {
        return lottos.size() * LottoConstants.AMOUNT_PER_LOTTO;
    }
}
