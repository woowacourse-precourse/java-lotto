package lotto;

import java.util.List;

public class LottoSeller {
    private static final String SUFFIX = "개를 구매했습니다.";

    public List<Lotto> sellLottos(int purchasePrice) {
        int countOfLottos = purchasePrice / Lotto.PRICE;

        System.out.println();
        System.out.println(countOfLottos + SUFFIX);

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.generateLottos(countOfLottos);

        return lottos;
    }
}
