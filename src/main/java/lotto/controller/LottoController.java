package lotto.controller;

import lotto.domain.LottoService;
import lotto.model.BuyingLottoList;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.LottoBuyView;
import lotto.view.LottoResultView;
import lotto.view.WinningNumberView;

import java.util.List;

public class LottoController {

    private final LottoBuyView lottoBuyView;
    private final WinningNumberView winningNumberView;
    private final LottoResultView lottoResultView;
    private final LottoService lottoService;

    public LottoController(LottoBuyView lottoBuyView, WinningNumberView winningNumberView,
                           LottoResultView lottoResultView, LottoService lottoService) {
        this.lottoBuyView = lottoBuyView;
        this.winningNumberView = winningNumberView;
        this.lottoResultView = lottoResultView;
        this.lottoService = lottoService;
    }

    public BuyingLottoList controlBuyingLotto() {
        int numberOfLotto = lottoBuyView.buyLotto();
        List<Lotto> lottoList = lottoService.generateLottoList(numberOfLotto);
        BuyingLottoList buyingLottoList = new BuyingLottoList(lottoList);
        lottoResultView.printBuyResult(buyingLottoList);

        return buyingLottoList;
    }

    public WinningLotto controlWinningLotto() {
        Lotto winningLotto = winningNumberView.inputWinningNumber();
        int bonusNumber = winningNumberView.inputBonusNumber(winningLotto);
        WinningLotto winningLottoInfo = new WinningLotto(winningLotto, bonusNumber);

        return winningLottoInfo;
    }

    public void controlResult(BuyingLottoList buyingLottoList, WinningLotto winningLottoInfo) {
        LottoResult lottoResult = lottoService.checkLottoResult(buyingLottoList, winningLottoInfo);
        lottoResultView.printResult(lottoResult);
    }
}
