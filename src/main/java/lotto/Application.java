package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.Money;
import lotto.domain.Buyer;
import lotto.domain.History;
import lotto.domain.WinningNumber;
import lotto.viewer.InputView;
import lotto.viewer.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            InputView.showPurchaseRequest();
            int purchaseNumber = Money.from(Console.readLine())
                    .calculatePurchaseNumber();
            InputView.showPurchaseNumber(purchaseNumber);
            Buyer buyer = Buyer.newInstance();
            buyer.buyLotto(purchaseNumber);
            InputView.showAllLotto(buyer);
            InputView.showWinningRequest();
            List<Integer> winningNumbers = Arrays.asList(Console.readLine().split(",")).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            InputView.showBonusRequest();
            int bonusNumber = Integer.parseInt(Console.readLine());
            WinningNumber winningNumber = WinningNumber.of(winningNumbers, bonusNumber);
            History history = buyer.play(winningNumber);
            OutputView.showHistory(history);
            OutputView.showProfitRate(history);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
