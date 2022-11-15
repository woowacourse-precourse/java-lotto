package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printPurchaseGuideMessage();
        PurchaseMoney purchaseMoney = InputView.inputPurchaseMoney();

        int lottoCount = purchaseMoney.getLottoCount();
        OutputView.printPurchaseResultMessage(lottoCount);

        Lottery lottery = new Lottery(lottoCount);
        OutputView.printLottoNumbers(lottery);

        OutputView.printWinningNumbersEnteringGuideMessage();
        List<Integer> winningLottoNumber = InputView.inputWinningNumbers();

        OutputView.printBonusNumbersEnteringGuideMessage();
        int bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumber), bonusNumber);
        OutputView.printResultMessage(lottery, winningLotto);



        List<Rank> ranks = new ArrayList<>();
        lottery.getLottery()
                .forEach(lotto -> ranks.add(winningLotto.getRank(lotto)));

        Result result = new Result(ranks);

        double yield = result.getYield(purchaseMoney.getPurchaseMoney());
        OutputView.printYieldMessage(yield);
    }
}
