package lotto.controller;

import lotto.domain.*;

import java.util.*;

import static lotto.domain.Preset.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    public void playLotto() {
        int inputMoney = readInputMoney();

        int purchaseNum = getPurchaseNum(inputMoney);
        printPurchaseNum(purchaseNum);

        Lottos purchasedLottos = new Lottos(purchaseNum);
        purchasedLottos.printLottoNumbers();

        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber();
        WinningLotto lotto = new WinningLotto(winningNumbers, bonusNumber);

        printResult(lotto, purchasedLottos, inputMoney);
    }

    public static int getPurchaseNum(int inputMoney) {
        return inputMoney / LOTTO_PRICE;
    }

}
