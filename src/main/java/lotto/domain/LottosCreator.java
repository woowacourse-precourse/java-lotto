package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottosCreator {

    public static final int LOTTO_PRICE = 1000;

    private LottosCreator() {
    }

    public static Lottos create(int purchasePrice) {
        return create(purchasePrice, RandomNumberCreator.createLottoNumber(calculateLottoCount(purchasePrice)));
    }

    public static Lottos create(int purchasePrice, List<List<Integer>> lottoNumbers) {
        int lottoCount = calculateLottoCount(purchasePrice);
        LottosValidationUtils.validateSize(lottoCount, lottoNumbers);

        return new Lottos(mapToLotto(lottoNumbers));
    }

    public static int calculateLottoCount(int purchasePrice) {
        LottosValidationUtils.validateCanPurchase(purchasePrice);
        return purchasePrice / LOTTO_PRICE;
    }

    private static List<Lotto> mapToLotto(List<List<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
