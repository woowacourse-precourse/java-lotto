package lotto;

import lotto.controller.EnterWinningNumber;
import lotto.controller.LottoPurchase;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.ResultPrint;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        List<Lotto> purchaseLottos = lottoPurchase.purchaseLottos();

        EnterWinningNumber enterWinningNumber = new EnterWinningNumber();
        WinningLotto winningLotto = enterWinningNumber.enterWinngLottoNumber();

        winningLotto.compareLotto(purchaseLottos);

        ResultPrint resultPrint = new ResultPrint();
        resultPrint.winningStatistics(winningLotto.getLottoRank());
        resultPrint.earningsRate(winningLotto.getearningRate());
    }
}
