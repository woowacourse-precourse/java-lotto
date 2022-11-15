package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningType;

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

        Map<WinningType, Integer> winningResults = getWinningResults(winningLotto, lottos);
        printWinningResult(winningResults);

        double earning = calculateEarning(winningResults, inputMoney);
        printEarning(earning);
    }

    public static Map<WinningType, Integer> getWinningResults(WinningLotto winningLotto, Lottos purchasedLottos) {

        Map<WinningType, Integer> winningResults = new EnumMap<>(WinningType.class);

        Boolean withBonus;
        for (Lotto lotto : purchasedLottos.getLottos()) {

            withBonus = false;
            int equalNumber = countEqualNumber(winningLotto, lotto);

            if (equalNumber == SECOND_WINNING) {
                equalNumber = FIVE_EQUALS;
                withBonus = true;
            }
            WinningType type = getWinningType(equalNumber, withBonus);
            countWinnings(winningResults, type);
        }

        return winningResults;
    }

    public static void countWinnings(Map<WinningType, Integer> winningResults, WinningType type) {

        if (winningResults.containsKey(type))
            winningResults.put(type, winningResults.get(type) + 1);

        if (!winningResults.containsKey(type))
            winningResults.put(type, 1);
    }

    public static void printWinningResult(Map<WinningType, Integer> winningResults) {

        Iterator<WinningType> winningTypeIterator = getWinningTypeIterator();
        while (winningTypeIterator.hasNext()) {
            WinningType type = winningTypeIterator.next();
            winningResults.putIfAbsent(type, 0);
            printEachWinningResult(type, winningResults);
        }
    }

    public static int countEqualNumber(WinningLotto winningLotto, Lotto userLotto) {

        int count = 0;
        for (int number : winningLotto.getLottoNumber())
            if (userLotto.contains(number))
                count += 1;

        if (count != FIVE_EQUALS)
            return count;

        int bonusNumber = winningLotto.getBonusNumber();
        if (userLotto.contains(bonusNumber))
            count = SECOND_WINNING;

        return count;
    }

    public static double calculateEarning(Map<WinningType, Integer> winningResults, int inputMoney) {

        double earning = 0;

        Iterator<WinningType> winningTypeIterator = getWinningTypeIterator();
        while (winningTypeIterator.hasNext()) {
            WinningType type = winningTypeIterator.next();
            earning += (double) type.getWinnings() * (double) winningResults.get(type);
        }
        earning /= inputMoney;

        return earning;
    }

    public static Iterator<WinningType> getWinningTypeIterator() {
        return Arrays.stream(WinningType.values()).iterator();
    }
}
