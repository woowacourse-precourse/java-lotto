package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int ONE_LOTTO_PRICE = 1000;

    public static int getLottoCount(int lottoPrice) {
        return lottoPrice / ONE_LOTTO_PRICE;
    }

    public static List<Lotto> getLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoCreator.createLotto());
        }

        return lottos;
    }
}
