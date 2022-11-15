package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.RandomGeneratorUtil.generateDistinctSixRandomNumberInRangeOneToFortyFive;
import static lotto.view.controller.LottoNumberView.printLottoNumbers;
import static lotto.view.controller.LottoNumberView.printTotalLottoCount;

public class LottoGenerateManager {

    private LottoGenerateManager() {
    }

    public static List<Lotto> generateTotalLotto(int totalBuyPrice) {
        int buyLottoCount = totalBuyPrice / LottoConfig.THOUSAND.getNumber();
        printTotalLottoCount(buyLottoCount);
        return createTotalLottoRepeatedly(buyLottoCount);
    }

    private static List<Lotto> createTotalLottoRepeatedly(Integer lottoCount) {
        List<Lotto> newTotalLotto = new ArrayList<>(lottoCount+1);
        for (int i = 0; i < lottoCount; i++) {
            newTotalLotto.add(generateLotto());
        }
        return newTotalLotto;
    }

    private static Lotto generateLotto() {
        List<Integer> newLottoNumbers = generateDistinctSixRandomNumberInRangeOneToFortyFive();
        printLottoNumbers(newLottoNumbers);
        return new Lotto(newLottoNumbers);
    }

}
