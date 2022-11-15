package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.WinningNumber;
import lotto.viewer.InputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    public static final String COMMA = ",";
    public static int enterPurchaseNumber() {
        InputView.showPurchaseRequest();
        int purchaseNumber = Money.from(Console.readLine())
                .calculatePurchaseNumber();
        InputView.showPurchaseNumber(purchaseNumber);
        return purchaseNumber;
    }

    public static Buyer buyLottos(int purchaseNumber) {
        Buyer buyer = Buyer.newInstance();
        buyer.buyLotto(purchaseNumber);
        InputView.showAllLotto(buyer);
        return buyer;
    }

    public static List<Integer> enterWinningNumbers() {
        InputView.showWinningRequest();
        List<Integer> winningNumbers = Arrays.asList(Console.readLine().split(COMMA)).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public static int enterBonusNumber() {
        InputView.showBonusRequest();
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

    public static WinningNumber enterWinningNumber() {
        List<Integer> winningNumbers = enterWinningNumbers();
        int bonusNumber = enterBonusNumber();
        WinningNumber winningNumber = WinningNumber.of(winningNumbers, bonusNumber);
        return winningNumber;
    }
}
