package lotto;

import java.util.List;

public class LottoSeller {
    private static final String SUFFIX = "개를 구매했습니다.";

    public List<Lotto> sellLottos(int purchasePrice) {
        int countOfLottos = getCountOfLottos(purchasePrice);

        printMessage(countOfLottos);

        List<Lotto> lottos = generateLottos(countOfLottos);

        return lottos;
    }

    private int getCountOfLottos(int purchasePrice) {
        return purchasePrice / Lotto.PRICE;
    }

    private void printMessage(int countOfLottos) {
        System.out.println();
        System.out.println(countOfLottos + SUFFIX);
    }

    private List<Lotto> generateLottos(int countOfLottos) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.generateLottos(countOfLottos);

        return lottos;
    }
}
