package lotto.service;

import static lotto.domain.LottoGenerator.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;

public class LottoService {

    public static final int MAKE_PERCENTAGE_SCALE = 100;

    private LottoGenerator lottoGenerator = new LottoGenerator();

    public List<LottoResult> compareLottoNumbers(List<Lotto> lottoBundle,
                                                 List<Integer> winningNumbers,
                                                 int bonusNumber) {
        return lottoBundle.stream()
                .map(lotto -> LottoResult.of(lotto,winningNumbers,bonusNumber))
                .collect(Collectors.toList());
    }

    public double calculateYield(List<LottoResult> lottoResults) {
        int revenue = lottoResults.stream()
                .mapToInt(LottoResult::getPayout)
                .sum();
        int investment = lottoResults.size() * LOTTO_PRICE;

        return (double) revenue / investment * MAKE_PERCENTAGE_SCALE;
    }

    public List<Lotto> buy(int money) {
        return lottoGenerator.createLottoBundle(money);
    }
}
