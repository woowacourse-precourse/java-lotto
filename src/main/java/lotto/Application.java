package lotto;

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
            LottoBuyView lottoServiceView = new LottoBuyView();
            WinningNumberView winningNumberView = new WinningNumberView();
            LottoResultView lottoResultView = new LottoResultView();
            LottoService lottoService = new LottoService();

            int numberOfLotto = lottoServiceView.buyLotto();
            BuyingLottoList buyingLottoList = new BuyingLottoList(lottoService.generateLottoList(numberOfLotto));
            lottoResultView.printBuyResult(buyingLottoList);
            Lotto winningLotto = winningNumberView.inputWinningNumber();
            int bonusNumber = winningNumberView.inputBonusNumber(winningLotto);
            WinningLotto winningLottoInfo = new WinningLotto(winningLotto, bonusNumber);

            LottoResult lottoResult = lottoService.checkLottoResult(buyingLottoList, winningLottoInfo);
            lottoResultView.printResult(lottoResult);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
