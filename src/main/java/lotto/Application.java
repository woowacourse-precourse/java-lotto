package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoService;
import lotto.model.BuyingLottoList;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.LottoBuyView;
import lotto.view.LottoResultView;
import lotto.view.WinningNumberView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoBuyView lottoBuyView = new LottoBuyView();
            WinningNumberView winningNumberView = new WinningNumberView();
            LottoResultView lottoResultView = new LottoResultView();
            LottoService lottoService = new LottoService();

            LottoController lottoController = new LottoController(lottoBuyView, winningNumberView,
                    lottoResultView, lottoService);

            BuyingLottoList buyingLottoList = lottoController.controlBuyingLotto();
            WinningLotto winningLottoInfo = lottoController.controlWinningLotto();
            lottoController.controlResult(buyingLottoList, winningLottoInfo);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
