package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.model.LottoBuyer;
import lotto.model.LottoWinningNumber;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {
    LottoInputView lottoInputView = new LottoInputView();
    LottoOutputView lottoOutputView = new LottoOutputView();
    LottoGenerator lottoGenerator = new LottoGenerator();

    public void LottoSimulationInit() {
        LottoBuyer lottoBuyer = new LottoBuyer(lottoInputView.inputBuyAmount());
        lottoOutputView.printBuyAmount(lottoBuyer);

        lottoGenerator.generateRandomLotto(lottoBuyer);
        lottoOutputView.printLottoInfo(lottoBuyer);

        List<Integer> winningNumbers = lottoInputView.inputWinningNumbers();
        int bonusNumber = lottoInputView.inputBonusNumber();
        LottoWinningNumber lottoWinningNumbers = new LottoWinningNumber(winningNumbers, bonusNumber);

        lottoOutputView.printLottoStatistics(lottoBuyer, lottoWinningNumbers);
        lottoOutputView.printLottoProfitRate(lottoBuyer);
    }
}