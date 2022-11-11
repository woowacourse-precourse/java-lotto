package lotto.domain;

import lotto.constant.Score;

import java.util.List;
import java.util.Map;

public class LottoMachine {

    private final LottoService lottoService;

    public LottoMachine(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int money = lottoService.printAndInputMoney();
        int lottoCount = lottoService.getAndPrintLottoPurchaseCount(money);

        List<List<Integer>> randomLottoNumbers = lottoService.printAndGetRandomLottoNumbers(lottoCount);
        List<Integer> lottoNumber = lottoService.printAndInputLottoNumber();
        int bonusNumber = lottoService.printAndInputBonusNumber();

        Map<Score, Integer> scoreStore = lottoService.calculateLottoScore(lottoNumber, randomLottoNumbers, bonusNumber);
        String profitRate = lottoService.getProfitRate(scoreStore, money);
        lottoService.printResult(scoreStore, profitRate);
    }
}
