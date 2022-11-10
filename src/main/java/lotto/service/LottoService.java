package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;

public class LottoService {

    private LottoGenerator lottoGenerator = new LottoGenerator();

    public List<LottoResult> compareLottoNumbers(List<Lotto> lottoBundle,
                                                 List<Integer> winningNumbers,
                                                 int bonusNumber) {
        return lottoBundle.stream()
                .map(lotto -> lotto.result(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    public double calculateYield(List<LottoResult> lottoResults) {
        int revenue = lottoResults.stream()
                .mapToInt(LottoResult::getPayout)
                .sum();
        int investment = lottoResults.size() * 1000;

        return (double) revenue / investment * 100;
    }

    public List<Lotto> buy(int money) {
        return lottoGenerator.createLottoBundle(money);
    }
}
