package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningType;

import java.text.DecimalFormat;
import java.util.*;

import static lotto.domain.Preset.LOTTO_LENGTH;
import static lotto.domain.Preset.LOTTO_PRICE;
import static lotto.domain.WinningType.getWinningType;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.printPurchaseNum;

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

        // 당첨 통계를 구하는 메서드 호출
        printResult(lotto, purchasedLottos, inputMoney);
    }

    public static int getPurchaseNum(int inputMoney) {
        return inputMoney / LOTTO_PRICE;
    }

    public static void printResult(WinningLotto winningLotto, Lottos lottos, int inputMoney) {
        System.out.println("당첨 통계\n" + "---");

        Map<WinningType, Integer> winningResults = new EnumMap<>(WinningType.class);

        for (Lotto lotto : lottos.getLottos()) {

            Boolean withBonus = false;
            int equalNumber = equalNumberCounter(winningLotto, lotto);

            if (equalNumber == 7) {
                withBonus = true;
                equalNumber = 5;
            }
            WinningType type = getWinningType(equalNumber, withBonus);

            if (winningResults.containsKey(type)) {
                winningResults.put(type, winningResults.get(type) + 1);

            } else winningResults.put(type, 1);
        }

        printResultElements(winningResults);

        calculateEarning(winningResults, inputMoney);
    }

    public static void printResultElements(Map<WinningType, Integer> winningResults) {

        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        Iterator<WinningType> winningTypeIterator = Arrays.stream(WinningType.values()).iterator();
        while (winningTypeIterator.hasNext()) {
            WinningType type = winningTypeIterator.next();
            if (type != WinningType.NONE) {
                System.out.print(type.getEqualCount());
                System.out.print("개 일치");

                if (type.getWithBonus())
                    System.out.print(", 보너스 볼 일치");
                System.out.print(" (" + decimalFormat.format(type.getWinnings()) + "원) - ");

                winningResults.putIfAbsent(type, 0);
                System.out.println(winningResults.get(type) + "개");
            }
        }
    }

    public static int equalNumberCounter(WinningLotto winningLotto, Lotto userLotto) {

        int count = 0;
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            int number = winningLotto.getLottoNumber(i);

            if (userLotto.getNumbers().contains(number))
                count += 1;
        }

        if (count == 5) {
            int bonusNumber = winningLotto.getBonusNumber();

            if (userLotto.getNumbers().contains(bonusNumber))
                count = 7;
        }

        return count;
    }

    public static void calculateEarning(Map<WinningType, Integer> winningResults, int inputMoney) {

        double earning = 0;

        Iterator<WinningType> winningTypeIterator = Arrays.stream(WinningType.values()).iterator();
        while (winningTypeIterator.hasNext()) {
            WinningType type = winningTypeIterator.next();
            earning += (double) type.getWinnings() * (double) winningResults.get(type);
        }
        earning /= inputMoney;

        System.out.println("총 수익률은 " + String.format("%.1f", earning * 100) + "%입니다.");
    }
}
