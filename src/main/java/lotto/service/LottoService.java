package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoService {
    public Money purchase(String purchaseAmount) {
        return new Money(purchaseAmount);
    }

    public List<Lotto> generateLottos(Money money) {
        LottoGenerateService lottoGenerateService = new LottoGenerateService();
        return lottoGenerateService.generate(money);
    }

    public WinningNumbers generateWinningNumbers(String numbers, String bonus) {
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonus);
        return winningNumbers;
    }

    public Statistics generateStatistics(WinningNumbers winningNumbers, List<Lotto> lottos) {
        StatisticsGenerateService statisticsGenerateService = new StatisticsGenerateService();
        return statisticsGenerateService.generate(winningNumbers, lottos);
    }
}
