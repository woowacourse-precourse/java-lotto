package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputUi;
import lotto.ui.OutputUi;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputUi inputUi = new InputUi();
    private final OutputUi outputUi = new OutputUi();

    public void startLottoApp() {
        try {
            outputUi.printBuyAmount();
            String buyAmountBill = inputUi.inputBuyAmount();

            LottoStore lottoStore = new LottoStore(new LottoNumberCreator());
            List<Lotto> userLotteries = lottoStore.buyLotto(buyAmountBill);
            outputUi.printLottoAmountAndNumber(userLotteries);

            outputUi.printInputLottoWinNumber();
            String lottoWinNumber = inputUi.inputLottoWinNumber();
            LottoNumberCreator lottoNumberCreator = new LottoNumberCreator();
            Lotto lottoWinNumbers = lottoNumberCreator.createLottoWinNumber(lottoWinNumber);

            outputUi.printInputLottoBonusNumber();
            String lottoBonusNumber = inputUi.inputLottoBonusNumber();
            LottoBonusBall lottoBonusBall =
                    lottoNumberCreator.createLottoBonusBall(lottoBonusNumber, lottoWinNumbers);

            LottoAnalyzer lottoAnalyzer =
                    new LottoAnalyzer(userLotteries, lottoWinNumbers.getNumbers(), lottoBonusBall.getBonusBall());
            Map<LottoRank, Integer> lottoWinAmounts = lottoAnalyzer.analyzeLottoWin();
            outputUi.printWinLottoAmountsInformation(lottoWinAmounts);

            LottoProfitRate lottoProfitRate = new LottoProfitRate();
            double profitRate = lottoProfitRate.calculateProfitRate(userLotteries, lottoWinAmounts);
            outputUi.printLottoProfitRate(profitRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
