package lotto.service;

import static lotto.domain.LottoConstant.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;

public class LottoService {

    private static final int MAKE_PERCENTAGE_SCALE = 100;

    public List<Lotto> buy(int money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.createLottoBundle(money);
    }

    public List<LottoResult> compareLottoNumbers(List<Lotto> lottoBundle,
                                                 List<Integer> winningNumbers,
                                                 int bonusNumber) {
        return lottoBundle.stream()
                .map(lotto -> LottoResult.of(lotto.getNumberOfMatchesByWinningNumbers(winningNumbers),
                        lotto.containBonusNumber(bonusNumber)))
                .collect(Collectors.toList());
    }

    public double calculateYield(List<LottoResult> lottoResults) {
        int revenue = lottoResults.stream()
                .mapToInt(LottoResult::getPayout)
                .sum();

        int investment = lottoResults.size() * LOTTO_PRICE;

        return (double) revenue / investment  * MAKE_PERCENTAGE_SCALE;
    }
}
