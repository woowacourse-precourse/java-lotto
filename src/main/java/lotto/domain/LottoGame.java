package lotto.domain;

import lotto.Lotto;
import lotto.WinningLotto;
import lotto.view.Printer;

import java.util.List;
import java.util.Map;

public class LottoGame {

    private static LottoController lottoController = new LottoController();
    private static WinningController winningController = new WinningController();
    private static Printer printer = new Printer();
    private static double profitRate;
    private static int winMoney;

    public void start(){
        int price = lottoController.inputMoney();
        int lottoNumber = lottoController.calculateLottoNumber(price);
        printer.printNumberOfPurchasedLotto(lottoNumber);
        List<Lotto> purchasedLottos = lottoController.generatePurchasedLottos(lottoNumber);
        printer.printPurchasedLotto(purchasedLottos);
        WinningLotto winningLotto = lottoController.inputWinningLotto();
        Map<WinningStandard, Integer> winningResultMap = winningController.calculateWinningLottos(purchasedLottos, winningLotto);
        winMoney = winningController.getWinMoney(winningResultMap);
        profitRate = (double)winMoney / price;
        printer.printWinningStatistics(winningResultMap,profitRate);
    }
}
