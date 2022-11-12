package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Controller {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = inputMoney();
        System.out.println();
        createLottos(lottoPurchaseAmount.getPurchaseAmount());
        System.out.println();
        WinningNumbers winningNumbers = inputWinningNumbersAndBonusNumber();
    }

    public LottoPurchaseAmount inputMoney() {
        return new LottoPurchaseAmount(InputView.inputAmount());
    }

    public void createLottos(int purchaseAmount) {
        int countOfLotto = purchaseAmount / LOTTO_PRICE;
        Lottos lottos = new Lottos(Lottos.createLottoList(countOfLotto));


        System.out.printf("%d개를 구매했습니다.\n", countOfLotto);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }

    }
    public WinningNumbers inputWinningNumbersAndBonusNumber() {
        return InputView.inputWinningNumbersAndBonus();
    }

    public void createWinningStatistics() {

    }
}
