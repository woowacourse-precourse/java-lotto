package lotto;

import lotto.domain.LottoService;
import lotto.model.BuyingLottoList;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.LottoBuyView;
import lotto.view.WinningNumberView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoBuyView lottoServiceView = new LottoBuyView();
        WinningNumberView winningNumberView = new WinningNumberView();
        LottoService lottoService = new LottoService();

        int numberOfLotto = lottoServiceView.buyLotto();
        BuyingLottoList buyingLottoList = new BuyingLottoList(lottoService.generateLottoList(numberOfLotto));
        Lotto winningLotto = winningNumberView.inputWinningNumber();
        int bonusNumber = winningNumberView.inputBonusNumber();
        WinningLotto winningLottoInfo = new WinningLotto(winningLotto, bonusNumber);


    }
}
