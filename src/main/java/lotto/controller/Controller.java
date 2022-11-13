package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Controller {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = inputMoney();
        System.out.println();

        Lottos lottos = createLottos(lottoPurchaseAmount.getPurchaseAmount());
        System.out.println();

        WinningNumbers winningNumbers = inputWinningNumbersAndBonusNumber();

        LottoResult lottoResult = new LottoResult();
        lottoResult.addMatchRankCount(lottos, winningNumbers);

        OutputView outputView = new OutputView();
        outputView.printResult(lottoResult, lottoPurchaseAmount);
    }

    public LottoPurchaseAmount inputMoney() {
        return new LottoPurchaseAmount(InputView.inputAmount());
    }

    public Lottos createLottos(int purchaseAmount) {
        int countOfLotto = purchaseAmount / LOTTO_PRICE;

        Lottos lottos = new Lottos(Lottos.createLottoList(countOfLotto));

        System.out.printf("%d개를 구매했습니다.\n", countOfLotto);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }

        return lottos;
    }
    public WinningNumbers inputWinningNumbersAndBonusNumber() {
        return InputView.inputWinningNumbersAndBonus();
    }
}
