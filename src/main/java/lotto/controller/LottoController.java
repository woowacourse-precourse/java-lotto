package lotto.controller;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.*;

import static lotto.domain.Preset.*;
import static lotto.domain.WinningType.getWinningType;
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

    public static void printResult(WinningLotto winningLotto, Lottos lottos, int inputMoney) {

        printResultMainMessage();

        WinningResult result = getWinningResults(winningLotto, lottos);
        result.print();

        double earning = result.calculateEarning(inputMoney);
        printEarning(earning);
    }

    public static WinningResult getWinningResults(WinningLotto winningLotto, Lottos purchasedLottos) {

        WinningResult result = new WinningResult();

        for (Lotto lotto : purchasedLottos.getLottos()) {

            boolean withBonus = false;
            int equalNumber = winningLotto.countEqualNumber(lotto);

            if (equalNumber == SECOND_WINNING) {
                WinningType type = getWinningType(FIVE_EQUALS, true);
                continue;
            }
            WinningType type = getWinningType(equalNumber, false);
            result.increaseOneByKey(type);
        }

        return result;
    }

    public static Iterator<WinningType> getWinningTypeIterator() {
        return Arrays.stream(WinningType.values()).iterator();
    }
}
