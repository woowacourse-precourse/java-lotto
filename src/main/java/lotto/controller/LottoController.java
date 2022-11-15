package lotto.controller;

import lotto.model.*;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lottoService;
    private MoneyService moneyService;
    private WinningNumbersService winningNumbersService;
    private RankingService rankingService;

    public void start() {
        purchaseLottos(insertMoney());
        pickWinningNumbers();
        profit();
    }

    private int insertMoney() {
        moneyService = new MoneyService(InputView.inputMoney());

        return moneyService.getLottoCount();
    }

    private void purchaseLottos(int lottoCount) {
        OutputView.outputAnnounceMoney(lottoCount);
        lottoService = new LottoService(lottoCount);
        OutputView.outputLottoList(lottoService.getLottoList());
    }

    private void pickWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        new WinningNumbersValidator(winningNumbers);

        String winningBonus = InputView.inputWinningBonus();
        new BonusNumberValidator(winningBonus);

        winningNumbersService = new WinningNumbersService(winningNumbers, winningBonus);
    }

    private void profit() {
        OutputView.outputWinningScript();
        WinningNumbers winningNumbers = winningNumbersService.getWinningNumbers();

        rankingService = new RankingService(winningNumbers, lottoService.getLottoList());
        rankingService.doAllRank();


        OutputView.outputWinningOrder(rankingService.getRanking());
        OutputView.outputProfitRate(rankingService.calculateProfitRate(moneyService.getMoney(),
                rankingService.calculateWinningMoney()));
    }
}
