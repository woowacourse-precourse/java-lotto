package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottosCreator {

    private LottosCreator() {
    }

    public static Lottos create(int purchasePrice) {
        return create(purchasePrice, RandomNumberCreator.createLottoNumber(calculateLottoCount(purchasePrice)));
    }

    public static Lottos create(int purchasePrice, List<List<Integer>> lottoNumbers) {
        int lottoCount = calculateLottoCount(purchasePrice);
        LottosCreatorValidUtils.validateSize(lottoCount, lottoNumbers);

        return new Lottos(mapToLotto(lottoNumbers));
    }

    public static int calculateLottoCount(int purchasePrice) {
        LottosCreatorValidUtils.validateCanPurchase(purchasePrice);
        return purchasePrice / Player.LOTTO_PRICE;
    }

    private static List<Lotto> mapToLotto(List<List<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
