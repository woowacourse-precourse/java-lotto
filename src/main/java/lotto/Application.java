package lotto;

import camp.nextstep.edu.missionutils.Console;
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
        InputView.showPurchaseRequest();
        int purchaseMoney = Integer.parseInt(Console.readLine());
        int purchaseNumber = CalculateNumber(purchaseMoney);
        InputView.showPurchaseNumber(purchaseNumber);
        Buyer buyer = Buyer.newInstance();
        buyer.buyLotto(purchaseNumber);
        InputView.showAllLotto(buyer);
        InputView.showWinningRequest();
        List<Integer> winningNumbers = Arrays.asList(Console.readLine().split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int bonusNumber = Integer.parseInt(Console.readLine());
        WinningNumber winningNumber = WinningNumber.of(winningNumbers, bonusNumber);
        History history = buyer.play(winningNumber);
        OutputView.showHistory(history);
        OutputView.showProfitRate(history);


    }

    private static int CalculateNumber(int purchaseMoney) {
        if (purchaseMoney%1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력해주세요.");
        }
        return purchaseMoney/1000;
    }
}
